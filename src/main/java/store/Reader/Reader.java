package store.Reader;

import store.model.Paycheck;

public interface Reader {
    public Paycheck readFromArgs(String[] args);
}
