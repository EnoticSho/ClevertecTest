package store.cardService;

import store.model.DiscountCard;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCardServiceImpl implements CardService {

    private List<DiscountCard> cardList;

    public InMemoryCardServiceImpl() {
        cardList = new ArrayList<>();
        cardList.add(new DiscountCard("123", 17));
        cardList.add(new DiscountCard("124", 17));
        cardList.add(new DiscountCard("125", 17));
        cardList.add(new DiscountCard("126", 17));
        cardList.add(new DiscountCard("127", 17));
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
