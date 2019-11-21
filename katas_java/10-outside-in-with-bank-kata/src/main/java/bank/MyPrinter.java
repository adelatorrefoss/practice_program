package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyPrinter implements Printer {

  private Display display;

  public MyPrinter(Display display) {
    this.display = display;
  }

  @Override
  public void print(Statement statement) {
    List<Movement> movements = statement.retrieveMovements();

    display.print("date || credit || debit || balance");

    if (!movements.isEmpty()) {
      Movement movement = movements.get(0);
      display.print(formatDate(movement.date()) + " || " +
                    formatAmount(movement.credit()) + " || " + formatAmount(movement.debit()) + " || " +
                    movement.balance());
    }

  }

  private String formatAmount(int amount) {
    if(amount != 0) {
      return Integer.toString(amount);
    }
    return "";
    }

  private String formatDate(LocalDate date) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return date.format(dateFormatter);
  }
}
