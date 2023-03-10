package store;

import store.Reader.ArgsCheckService;
import store.Reader.CheckService;
import store.Reader.CheckServiceDB;
import store.Reader.CheckServiceFile;
import store.cardService.DbCardService;
import store.cardService.InMemoryCardServiceImpl;
import store.model.Paycheck;
import store.productService.DbProductService;
import store.productService.InMemoryProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    private final String[] args;

    public ProductReader(String[] args) {
        this.args = args;
    }

    public void run() throws IOException {
        CheckService reader;
        if (args.length > 0 && Files.exists(Path.of(args[0]))) {
            reader = new CheckServiceFile(new ArgsCheckService(new InMemoryProductService(), new InMemoryCardServiceImpl()));
        } else if (args.length != 0){
            reader = new ArgsCheckService(new InMemoryProductService(), new InMemoryCardServiceImpl());
        } else {
            reader = new CheckServiceDB(new ArgsCheckService(new DbProductService(), new DbCardService()));
        }
        Paycheck paycheck = reader.readArgs(args);
        reader.writeCheckToFile(paycheck);
        System.out.println(paycheck);
    }
}
