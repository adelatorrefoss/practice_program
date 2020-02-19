package alert_service;

import java.util.Objects;

public class UnusualSpending {
    private String category;
    private double amount;

    public UnusualSpending(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnusualSpending that = (UnusualSpending) o;
        return Double.compare(that.amount, amount) == 0 &&
                category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, amount);
    }

    @Override
    public String toString() {
        return "UnusualSpending{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}
