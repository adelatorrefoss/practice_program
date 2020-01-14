package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    private Account account;
    private Calendar calendar;
    private TransactionRepository transactionRepository;
    private Printer printer;
    private Console console;

    @Before
    public void setUp() {
        printer = mock(Printer.class);
        calendar = mock(Calendar.class);
        transactionRepository = mock(TransactionRepository.class);
        console = mock(Console.class);

        account = new Account(calendar, printer, transactionRepository, console);
    }

    @Test
    public void make_a_deposit() throws ParseException {
        Date today = new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012");
        when(calendar.today()).thenReturn(today);
        account.deposit(1000);

        Transaction transaction = new Transaction(today, 1000);
        verify(transactionRepository).save(transaction);
    }

    @Test
    public void make_a_withdraw() throws ParseException {
        Date today = new SimpleDateFormat("dd-MM-yyyy").parse("13-01-2012");
        when(calendar.today()).thenReturn(today);
        account.withdraw(500);

        Transaction transaction = new Transaction(today, -500);
        verify(transactionRepository).save(transaction);
    }

    @Test
    public void print_an_empty_statement() {
        account.printStatement();
        Statement statement = new Statement();
        verify(console).print(statement);
    }

    @Test
    public void print_a_statement() throws ParseException {
        Date today = new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012");
        Date tomorrow = new SimpleDateFormat("dd-MM-yyyy").parse("11-01-2012");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(today, 1000));
        transactions.add(new Transaction(tomorrow, -400));
        when(transactionRepository.list()).thenReturn(transactions);

        account.printStatement();
        Statement statement = new Statement();
        statement.lines.add(new StatementLine(today, 1000, 1000));
        statement.lines.add(new StatementLine(tomorrow, -400, 600));

        verify(console).print(statement);
    }
}
