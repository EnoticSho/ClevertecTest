package store.productService;

import store.model.Product;
import store.model.ProductsInit;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductService implements ProductService {

    private final List<Product> productList;

    public InMemoryProductService() {
        productList = new ArrayList<>();
        productList.add(new Product(ProductsInit.APPLE));
        productList.add(new Product(ProductsInit.ORANGE));
        productList.add(new Product(ProductsInit.CUCUMBER));
        productList.add(new Product(ProductsInit.LEMON));
        productList.add(new Product(ProductsInit.TOMATO));
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
