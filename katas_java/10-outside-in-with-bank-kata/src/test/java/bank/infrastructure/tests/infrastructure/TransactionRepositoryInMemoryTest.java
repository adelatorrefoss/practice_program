package bank.infrastructure.tests.infrastructure;

import bank.Transaction;
import bank.infrastructure.TransactionRepositoryInMemory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TransactionRepositoryInMemoryTest {

    @Test
    public void save_and_list() {
        TransactionRepositoryInMemory transactionRepositoryInMemory = new TransactionRepositoryInMemory();
        Date today = new Date();
        Transaction transactionToday = new Transaction(today, 1000);
        Transaction transactionTomorrow = new Transaction(today, 25000);
        transactionRepositoryInMemory.save(transactionToday);
        transactionRepositoryInMemory.save(transactionTomorrow);
        List<Transaction> transactions = transactionRepositoryInMemory.list();
        assertThat(transactions.get(0), is(transactionToday));
        assertThat(transactions.get(1), is(transactionTomorrow));
    }
}
