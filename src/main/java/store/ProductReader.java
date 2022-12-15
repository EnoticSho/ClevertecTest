package store;

import store.Reader.ArgsReader;
import store.Reader.FileReader;
import store.Reader.Reader;
import store.model.Paycheck;
import store.model.PaycheckWithoutDiscount;
import store.productService.InMemoryProductService;
import store.productService.ProductService;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {

    private final String[] pairProducts;
    private final ProductService productService;

    private Reader reader;
    private PaycheckWithoutDiscount paycheck;

    public ProductReader(String[] args) {
        productService = new InMemoryProductService();
        pairProducts = args;
    }

    public void run() {
//        if (Files.exists(Path.of(pairProducts[0]))) {
//            reader = new FileReader(new ArgsReader());
//        }
        reader = new ArgsReader();
        Paycheck paycheck1 = reader.readFromArgs(pairProducts);
        System.out.println(paycheck1);
    }
}
