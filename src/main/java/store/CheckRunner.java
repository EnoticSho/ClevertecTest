package store;

import java.io.IOException;

public class CheckRunner {
    public static void main(String[] args) throws IOException {
        final ProductReader productReader = new ProductReader(args);
        productReader.run();
    }
}
