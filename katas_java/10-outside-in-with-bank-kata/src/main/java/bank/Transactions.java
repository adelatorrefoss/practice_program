package bank;

import java.util.List;

public interface Transactions {

  void save(int amount);

  List<Transaction> retrieve();
}
