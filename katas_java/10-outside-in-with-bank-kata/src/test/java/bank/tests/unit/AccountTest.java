package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

public class AccountTest {

    private Account account;
    private Calendar calendar;
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() {
        Printer printer = mock(Printer.class);
        calendar = mock(Calendar.class);
        transactionRepository = mock(TransactionRepository.class);

        account = new Account(calendar, printer, transactionRepository);
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
}
