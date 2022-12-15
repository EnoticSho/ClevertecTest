package store;

public class CheckRunner {
    public static void main(String[] args) {
        final ProductReader productReader = new ProductReader(args);
        productReader.run();
    }
}
