package bank;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

public class Statement {

  private List<Transaction> transactionsList;
  private List<Movement> movements;


  public Statement(List<Transaction> transactionsList) {
    this.transactionsList = transactionsList;
    movements = Lists.newArrayList();
    int balance = 0;
    for(Transaction transaction : transactionsList){
        balance = balance + transaction.getAmount();
        movements.add(new Movement(transaction.getDate(), transaction.getAmount(), balance));
    }
  }

  public List<Movement> retrieveMovements() {
    return movements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statement statement = (Statement) o;
    return Objects.equals(transactionsList, statement.transactionsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionsList);
  }

}
