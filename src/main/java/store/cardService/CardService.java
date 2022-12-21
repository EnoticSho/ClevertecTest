package store.cardService;

import java.io.Closeable;

public interface CardService extends Closeable {
    int getDiscountAmountByName(String name);
}
