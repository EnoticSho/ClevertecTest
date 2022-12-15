package store.productService;

import store.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductService implements ProductService {

    private final List<Product> productList;

    public InMemoryProductService() {
        productList = new ArrayList<>();
        productList.add(new Product("apple", 100, true));
        productList.add(new Product("orange", 200, false));
        productList.add(new Product("cucumber", 300,false));
        productList.add(new Product("lemon", 1500,false));
        productList.add(new Product("tomato", 400, true));
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
