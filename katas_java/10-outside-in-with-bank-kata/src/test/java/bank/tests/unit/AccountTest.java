package bank.tests.unit;

import bank.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

public class AccountTest {
    @Test
    public void make_a_deposit() throws ParseException {
        Date today = new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012");

        Printer printer = mock(Printer.class);
        Calendar calendar = mock(Calendar.class);
        when(calendar.today()).thenReturn(today);
        Account account = new Account(calendar, printer);
        account.deposit(1000);

        Transaction transaction = new Transaction(today, 1000);

        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        verify(transactionRepository).save(transaction);
    }
}
