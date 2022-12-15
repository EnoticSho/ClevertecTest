package store.Reader;

import store.Product;
import store.model.Paycheck;
import store.model.PaycheckWithoutDiscount;
import store.productService.InMemoryProductService;
import store.productService.ProductService;

import java.util.HashMap;
import java.util.Map;

public class ArgsReader extends DecoratorReader{
    private final Map<Product, Integer> map = new HashMap<>();
    private int totalCost;
    private final ProductService productService = new InMemoryProductService();

    private Paycheck paycheck;

    public Paycheck readFromArgs(String[] args) {
        Map<Product, Integer> map = new HashMap<>();
        int totalCost = 0;
        for (String string : args) {
            int i = Integer.parseInt(string.substring(0, string.indexOf('-')));
            int i1 = Integer.parseInt(string.substring(string.indexOf('-') + 1));
            map.put(productService.getProductById(i), i1);
            totalCost += productService.getProductById(i).getCost() * i1;
        }
        paycheck = new PaycheckWithoutDiscount.Builder().withProducts(map).build();
        System.out.println(paycheck.toString());
        System.out.println(totalCost);
        System.out.println(map);
        return paycheck;
    }
}
