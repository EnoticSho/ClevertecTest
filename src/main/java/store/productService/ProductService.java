package store.productService;

import store.model.Product;

import java.io.Closeable;

public interface ProductService extends Closeable {

    public Product getProductById(int id);
}
