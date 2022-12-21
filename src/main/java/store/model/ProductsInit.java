package store.model;

public enum ProductsInit {

    APPLE("apple", 100, true),
    ORANGE("orange", 200, true),
    CUCUMBER("cucumber", 300, false),
    LEMON("lemon", 1500, false),
    TOMATO("tomato", 400, true);

    private final String name;
    private final int cost;
    private final boolean isDiscount;

    ProductsInit(String name, int cost, boolean isDiscount) {
        this.name = name;
        this.cost = cost;
        this.isDiscount = isDiscount;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
