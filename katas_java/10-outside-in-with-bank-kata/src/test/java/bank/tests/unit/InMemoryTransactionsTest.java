package bank.tests.unit;

import bank.Calendar;
import bank.InMemoryTransactions;
import bank.Transaction;
import bank.Transactions;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InMemoryTransactionsTest {

    @Test
    public void retrieve_when_no_transactions() {
        Transactions inMemoryTransactions = new InMemoryTransactions();

        List<Transaction> transactionList = inMemoryTransactions.retrieve();

        List<Transaction> expectedTransactionList = Lists.newArrayList();
        assertThat(transactionList, is(expectedTransactionList));
    }

    @Test
    public void retrieve_when_one_transaction() {
        Calendar calendar = mock(Calendar.class);
        LocalDate date = LocalDate.of(2019, 3, 10);
        when(calendar.now()).thenReturn(date);
        Transactions inMemoryTransactions = new InMemoryTransactions(calendar);
        inMemoryTransactions.save(1000);

        List<Transaction> transactionList = inMemoryTransactions.retrieve();

        List<Transaction> expectedTransactionList = Lists.newArrayList(
                new Transaction(date, 1000)
        );
        assertThat(transactionList, is(expectedTransactionList));
    }
}
