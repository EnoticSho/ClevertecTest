package store.productService;

import store.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductService implements ProductService {

    private final List<Product> productList;

    public InMemoryProductService() {
        productList = new ArrayList<>();
        productList.add(new Product("apple", 100));
        productList.add(new Product("orange", 200));
        productList.add(new Product("cucumber", 300));
        productList.add(new Product("lemon", 1500));
        productList.add(new Product("tomato", 400));
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
