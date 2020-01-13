package bank.tests.acceptance;

import bank.Account;
import bank.Calendar;
import bank.Printer;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class PrintingAccountStatementOnConsoleTest {
    @Test
    public void printing_statement_including_deposit_and_withdrawal() throws ParseException {
        Printer printer = mock(Printer.class);
        Calendar calendar = mock(Calendar.class);
        when(calendar.today()).thenReturn(
                new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("13-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("14-01-2012"));
        Account account = new Account(calendar, printer);
        account.deposit(1000);
        account.deposit(500);
        account.withdraw(500);

        verify(printer).print("date || credit || debit || balance\n" +
                "14/01/2012 || || 500.00 || 2500.00\n" +
                "13/01/2012 || 2000.00 || || 3000.00\n" +
                "10/01/2012 || 1000.00 || || 1000.00");
    }
}
