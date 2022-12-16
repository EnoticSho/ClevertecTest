package store.Reader;

import store.model.Paycheck;

import java.io.IOException;

public interface CheckService {
    public Paycheck readArgs(String[] array);

    public void writeCheckToFile(Paycheck paycheck) throws IOException;
}
