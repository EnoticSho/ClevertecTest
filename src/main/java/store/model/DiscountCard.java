package store.model;

public class DiscountCard {
    private final String name;
    private final int percent;

    public DiscountCard(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }
}
