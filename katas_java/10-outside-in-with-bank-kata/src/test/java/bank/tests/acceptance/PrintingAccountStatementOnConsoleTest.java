package bank.tests.acceptance;

import bank.Account;
import bank.Calendar;
import bank.Display;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class PrintingAccountStatementOnConsoleTest {
    @Test
    public void printing_statement_including_deposit_and_withdrawal() {
        Calendar calendar = mock(Calendar.class);
        Display display = mock(Display.class);
        Account account = new Account(calendar, display);

        when(calendar.now()).thenReturn(
                LocalDate.of(2012, 1, 10),
                LocalDate.of(2012, 1, 13),
                LocalDate.of(2012, 1, 14)
        );

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        verify(display).print("date || credit || debit || balance");
        verify(display).print("14/01/2012 || || 500.00 || 2500.00");
        verify(display).print("13/01/2012 || 2000.00 ||  || 3000.00");
        verify(display).print("10/01/2012 || 1000.00 ||  || 1000.00");
    }
}
