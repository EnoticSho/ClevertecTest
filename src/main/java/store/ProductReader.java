package store;

import store.Reader.ArgsReader;
import store.Reader.Reader;
import store.productService.InMemoryProductService;
import store.productService.ProductService;

import java.util.Arrays;

public class ProductReader {

    private final String[] pairProducts;
    private final ProductService productService;

    private Reader reader;
    private Paycheck paycheck;

    public ProductReader(String[] args) {
        productService = new InMemoryProductService();
        pairProducts = args;
    }

    public void run() {
        if (Arrays.asList(pairProducts).contains("card")){
            reader =
        } else {
            reader = new ArgsReader();
        }
        paycheck = reader.readFromArgs(args)
    }
}
