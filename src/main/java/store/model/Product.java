package store.model;

public class Product {

    private static int idInit = 0;
    private final int id;
    private final String name;
    private int cost;
    private boolean isDiscount;

    public Product(int id, String name, int cost, boolean isDiscount) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.isDiscount = isDiscount;
    }

    public Product(ProductsInit pr) {
        id = ++idInit;
        this.name = pr.getName();
        this.cost = pr.getCost();
        this.isDiscount = pr.isDiscount();
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }
}
