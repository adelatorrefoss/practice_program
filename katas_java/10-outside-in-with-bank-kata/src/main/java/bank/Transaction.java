package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date today;
    private final int amount;

    public Transaction(Date today, int amount) {
        this.today = today;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "today=" + today +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                today.equals(that.today);
    }

    @Override
    public int hashCode() {
        return Objects.hash(today, amount);
    }

}
