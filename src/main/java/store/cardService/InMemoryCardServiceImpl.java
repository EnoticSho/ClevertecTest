package store.cardService;

import store.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCardServiceImpl implements CardService {

    private final List<DiscountCard> cardList;

    public InMemoryCardServiceImpl() {
        cardList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cardList.add(new DiscountCard("12" + i, 17));
        }
    }

    @Override
    public int getDiscountAmountByName(String name) {
        for (DiscountCard discountCard : cardList) {
            if (discountCard.getName().equals(name)) {
                return discountCard.getPercent();
            }
        }
        return 0;
    }
}
