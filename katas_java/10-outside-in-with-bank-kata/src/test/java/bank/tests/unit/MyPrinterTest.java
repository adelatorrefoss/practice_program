package bank.tests.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import bank.Display;
import bank.MyPrinter;
import bank.Printer;
import bank.Statement;
import bank.Transaction;

public class MyPrinterTest {

  @Test
  public void print_only_header_when_no_transactions() {
    Display display = mock(Display.class);
    Printer printer = new MyPrinter(display);
    LocalDate date = LocalDate.of(2019, 3, 10);

    List<Transaction> transactions = Lists.newArrayList();
    Statement statement = new Statement(transactions);
    printer.print(statement);

    verify(display).print("date || credit || debit || balance");
  }

  @Test
  public void print_deposit_transaction() {
    Display display = mock(Display.class);
    Printer printer = new MyPrinter(display);
    LocalDate date = LocalDate.of(2019, 3, 10);

    List<Transaction> transactions = Lists.newArrayList(
        new Transaction(date, 100)
    );
    Statement statement = new Statement(transactions);
    printer.print(statement);

    verify(display).print("date || credit || debit || balance");
    verify(display).print("10/03/2019 || 100 ||  || 100");
  }

  @Test
  public void print_debit_transaction() {
    Display display = mock(Display.class);
    Printer printer = new MyPrinter(display);
    LocalDate date = LocalDate.of(2019, 3, 10);

    List<Transaction> transactions = Lists.newArrayList(
        new Transaction(date, -100)
    );
    Statement statement = new Statement(transactions);
    printer.print(statement);

    verify(display).print("date || credit || debit || balance");
    verify(display).print("10/03/2019 ||  || -100 || -100");
  }

}
