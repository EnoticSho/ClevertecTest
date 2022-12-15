package store;

import java.util.Map;

public class Paycheck {

    private Map<Product, Integer> products;
    private int totalCost;
    private boolean discount;
    private int discountAmount;

    public String convertToOut() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
            sb.append(productEntry.getValue()).append(" ")
                    .append(productEntry.getKey().getName()).append(" ")
                    .append(productEntry.getKey().getCost()).append(" ")
                    .append(productEntry.getValue() * productEntry.getKey().getCost())
                    .append("\n");
        }
        return sb.toString();
    }

    public static class Builder {
        private Paycheck paycheck;

        public Builder() {
            paycheck = new Paycheck();
        }

        public Builder withProducts(Map<Product, Integer> products) {
            paycheck.products = products;
            return this;
        }

        public Builder withTotalCost(int totalCost) {
            paycheck.totalCost = totalCost;
            return this;
        }

        public Builder withDiscount(boolean discount) {
            paycheck.discount = discount;
            return this;
        }

        public Builder withDiscountAmount(int discountAmount) {
            paycheck.discountAmount = discountAmount;
            return this;
        }

        public Paycheck build() {
            return paycheck;
        }
    }
}
