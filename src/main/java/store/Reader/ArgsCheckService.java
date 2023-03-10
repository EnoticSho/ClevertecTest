package store.Reader;

import store.cardService.CardService;
import store.model.Paycheck;
import store.model.Product;
import store.productService.ProductService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ArgsCheckService implements CheckService {
    private final CardService cardService;
    private final Map<Product, Integer> map;
    private final ProductService productService;
    private int totalCost;

    public ArgsCheckService(ProductService productService, CardService cardService) {
        this.productService = productService;
        this.cardService = cardService;
        map = new HashMap<>();
    }

    public Paycheck readArgs(String[] array) {
        Paycheck.Builder builder = new Paycheck.Builder();
        for (String string : array) {
            if (string.contains("card")) {
                int discountAmountByName = cardService.getDiscountAmountByName(
                        string.substring(string.indexOf('-') + 1));
                builder
                        .withDiscountAmount(discountAmountByName);
                break;
            }
            int id = Integer.parseInt(string.substring(0, string.indexOf('-')));
            int count = Integer.parseInt(string.substring(string.indexOf('-') + 1));
            Product product = productService.getProductById(id);
            if (product == null) {
                throw new RuntimeException("Продукта с таким ID не существует");
            }
            if (product.isDiscount() && count > 4) {
                totalCost += (product.getCost() * count) / 10 * 9;
            } else {
                totalCost += product.getCost() * count;
            }
            map.put(productService.getProductById(id), count);
        }
        return builder.withProducts(map).withTotalCost(totalCost).build();
    }

    @Override
    public void writeCheckToFile(Paycheck paycheck) throws IOException {
        String fileName = "Paychecks" + "/" + paycheck.getDate().toString().trim().replaceAll(":", "-");
        Files.createFile(Path.of(fileName));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(paycheck.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
