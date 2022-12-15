package store;

public class Product {
    private static int idInit = 0;
    private final int id;
    private final String name;
    private int cost;



    public Product(String name, int cost) {
        id = ++idInit;
        this.name = name;
        this.cost = cost;
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

    @Override
    public String toString() {
        return name + " " + cost;
    }
}
