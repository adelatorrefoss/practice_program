package bank;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;

public class InMemoryTransactions implements Transactions {

    private Calendar calendar;
    private List<Transaction> transactions = Lists.newArrayList();

    public InMemoryTransactions(Calendar calendar) {
        this.calendar = calendar;
    }

    public InMemoryTransactions() {

    }

    @Override
    public void save(int amount) {
        LocalDate date = calendar.now();
        transactions.add(
                new Transaction(date, amount)
        );
    }

    @Override
    public List<Transaction> retrieve() {
        return transactions;
    }
}
