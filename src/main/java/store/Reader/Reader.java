package store.Reader;

import store.Paycheck;

public interface Reader {
    public Paycheck readFromArgs(String[] args);
}
