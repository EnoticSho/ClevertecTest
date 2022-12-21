package store.Reader;

import store.model.Paycheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckServiceFile extends DecoratorCheckService {

    public CheckServiceFile(CheckService checkReader) {
        super(checkReader);
    }

    @Override
    public Paycheck readArgs(String[] array) {
        String string = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(array[0]))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                string = string.concat(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] s = string.trim().split(" ");
        return super.readArgs(s);
    }

    @Override
    public void writeCheckToFile(Paycheck paycheck) throws IOException {
        super.writeCheckToFile(paycheck);
    }
}
