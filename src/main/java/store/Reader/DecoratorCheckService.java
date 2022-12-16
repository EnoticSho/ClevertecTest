package store.Reader;

import store.model.Paycheck;

import java.io.IOException;

public class DecoratorCheckService implements CheckService {
    private CheckService checkReader;

        DecoratorCheckService(CheckService checkReader) {
        this.checkReader = checkReader;
    }

    @Override
    public Paycheck readArgs(String[] args) {
        return checkReader.readArgs(args);
    }

    @Override
    public void writeCheckToFile(Paycheck paycheck) throws IOException {
        checkReader.writeCheckToFile(paycheck);
    }
}
