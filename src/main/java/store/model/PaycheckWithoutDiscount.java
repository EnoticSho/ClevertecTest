package store.model;

import store.Product;

import java.util.Map;

public class PaycheckWithoutDiscount implements Paycheck{

    private Map<Product, Integer> products;
    private int totalCost;


    public String toString() {
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
        private PaycheckWithoutDiscount paycheck;

        public Builder() {
            paycheck = new PaycheckWithoutDiscount();
        }

        public Builder withProducts(Map<Product, Integer> products) {
            paycheck.products = products;
            return this;
        }

        public Builder withTotalCost(int totalCost) {
            paycheck.totalCost = totalCost;
            return this;
        }

        public PaycheckWithoutDiscount build() {
            return paycheck;
        }
    }
}
