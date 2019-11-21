package bank;

import java.time.LocalDate;

public class Movement {

  private final LocalDate date;
  private final int amount;
  int balance;

  public Movement(LocalDate date, int amount, int balance) {
    this.date = date;
    this.amount = amount;
    this.balance = balance;
  }

  public LocalDate date() {
    return date;
  }

  public int balance() {
    return balance;
  }

  public int credit() {
    if(amount > 0){
      return amount;
    }
    return 0;
  }

  public int debit() {
    if(amount < 0){
      return amount;
    }
    return 0;
  }
}
