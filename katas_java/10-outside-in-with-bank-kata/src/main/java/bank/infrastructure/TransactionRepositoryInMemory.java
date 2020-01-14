package bank.infrastructure;

import bank.Transaction;
import bank.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryInMemory implements TransactionRepository {
    private List<Transaction> list = new ArrayList<>();

    @Override
    public void save(Transaction transaction) {
        list.add(transaction);
    }

    @Override
    public List<Transaction> list() {
        return list;
    }
}
