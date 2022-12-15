package store.Reader;

import store.model.Paycheck;

public class DecoratorReader implements Reader{

    private Reader reader;

    @Override
    public Paycheck readFromArgs(String[] args) {
        return reader.readFromArgs(args);
    }
}
