package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date operationDate;
    private final int amount;

    public Transaction(Date operationDate, int amount) {
        this.operationDate = operationDate;
        this.amount = amount;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "today=" + operationDate +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                operationDate.equals(that.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationDate, amount);
    }

}
