package store.model;

import store.Product;

import java.util.Map;

public class PaycheckWithDiscount implements Paycheck {

    private Map<Product, Integer> products;
    private int totalCost;
    private boolean discount;
    private int discountAmount;
    @Override
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
        private PaycheckWithDiscount paycheck;

        public Builder() {
            paycheck = new PaycheckWithDiscount();
        }

        public PaycheckWithDiscount.Builder withProducts(Map<Product, Integer> products) {
            paycheck.products = products;
            return this;
        }

        public PaycheckWithDiscount.Builder withTotalCost(int totalCost) {
            paycheck.totalCost = totalCost;
            return this;
        }

        public PaycheckWithDiscount.Builder withDiscount(boolean discount) {
            paycheck.discount = discount;
            return this;
        }

        public PaycheckWithDiscount.Builder withDiscountAmount(int discountAmount) {
            paycheck.discountAmount = discountAmount;
            return this;
        }

        public PaycheckWithDiscount build() {
            return paycheck;
        }
    }
}
