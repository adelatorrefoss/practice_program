package bank;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> list();
}
