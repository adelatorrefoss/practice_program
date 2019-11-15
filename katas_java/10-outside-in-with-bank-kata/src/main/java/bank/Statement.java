package bank;

import java.util.List;
import java.util.Objects;

public class Statement {

    private List<Transaction> transactionsList;

    public Statement(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statement statement = (Statement) o;
        return Objects.equals(transactionsList, statement.transactionsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionsList);
    }
}
