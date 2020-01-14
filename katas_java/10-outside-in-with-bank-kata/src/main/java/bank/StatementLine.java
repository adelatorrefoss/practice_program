package bank;

import java.util.Date;
import java.util.Objects;

public class StatementLine {
    private final Date operationDate;
    private final int amount;
    private final int balance;

    public StatementLine(Date operationDate, int amount, int balance) {
        this.operationDate = operationDate;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "StatementLine{" +
                "operationDate=" + operationDate +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementLine that = (StatementLine) o;
        return amount == that.amount &&
                balance == that.balance &&
                Objects.equals(operationDate, that.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationDate, amount, balance);
    }
}
