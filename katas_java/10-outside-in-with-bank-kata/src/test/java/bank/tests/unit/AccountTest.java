package bank.tests.unit;

import bank.*;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void deposit_amount() {
        Transactions transactions = mock(Transactions.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactions, printer);
        int amount = 1000;

        account.deposit(amount);

        verify(transactions).save(amount);
    }

    @Test
    public void withdraw_amount() {
        Transactions transactions = mock(Transactions.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactions, printer);
        int amount = 1000;

        account.withdraw(amount);

        verify(transactions).save(-amount);
    }

    @Test
    public void print_statement() {
        Transactions transactions = mock(Transactions.class);
        List<Transaction> transactionsList = Lists.newArrayList();
        when(transactions.retrieve()).thenReturn(transactionsList);
        Printer printer = mock(Printer.class);
        Statement statement = new Statement(transactionsList);
        Account account = new Account(transactions, printer);

        account.printStatement();

        verify(transactions).retrieve();
        verify(printer).print(statement);
    }

}
