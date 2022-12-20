package store;

import store.Reader.ArgsCheckService;
import store.Reader.CheckService;
import store.Reader.CheckServiceFile;
import store.model.Paycheck;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ProductReader {
    private final String[] args;
    private CheckService reader;

    public ProductReader(String[] args) {
        this.args = args;
    }

    public void run() throws IOException {
        System.out.println(Arrays.toString(args));
        if (Files.exists(Path.of(args[0]))) {
            reader = new CheckServiceFile(new ArgsCheckService());
        } else {
            reader = new ArgsCheckService();
        }
        Paycheck paycheck = reader.readArgs(args);
        reader.writeCheckToFile(paycheck);
        System.out.println(paycheck);
    }
}
