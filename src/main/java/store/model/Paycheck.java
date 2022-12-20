package store.model;

import java.util.Date;
import java.util.Map;

public class Paycheck {

    private Map<Product, Integer> products;
    private int totalCost;
    private int discountAmount;
    private Date date;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Date: %tc%n%s%n%-5s %-14s %5s %7s%n", date,
                "----------------------------------", "Count", "Name", "Price", "Total"));
        for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
            String name = productEntry.getKey().getName();
            int cost = productEntry.getKey().getCost();
            Integer count = productEntry.getValue();
            int total = cost * count;
            String add = "";
            if (productEntry.getKey().isDiscount() && count > 4) {
                add = String.format("%20s %6d %s%n", "Discount: ", (total / 10), "(10%)");
                total = total - (total / 10);
            }
            sb.append(String.format("  %-3d %-14s %5d %7d%n", count, name, cost, total));
            sb.append(add);
        }
        int disc = discountAmount * totalCost / 100;
        int discPrice = totalCost - disc;
        String str = String.format("%s%n %19s %13d%n %19s %13d%n", "----------------------------------", "Total Cost:", totalCost, "Your discount:", disc);
        sb.append(str);
        str = String.format("%20s %13d", "Discounted price", discPrice);
        sb.append(str);
        return sb.toString();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public Date getDate() {
        return date;
    }

    public static class Builder {
        private Paycheck paycheck;

        public Builder() {
            paycheck = new Paycheck();
        }

        public Paycheck.Builder withProducts(Map<Product, Integer> products) {
            paycheck.products = products;
            return this;
        }

        public Paycheck.Builder withTotalCost(int totalCost) {
            paycheck.totalCost = totalCost;
            return this;
        }

        public Paycheck.Builder withDiscountAmount(int discountAmount) {
            paycheck.discountAmount = discountAmount;
            return this;
        }

        public Paycheck build() {
            paycheck.date = new Date();
            return paycheck;
        }
    }
}
