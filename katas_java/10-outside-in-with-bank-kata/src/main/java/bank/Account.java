package bank;

import java.util.List;

public class Account {
    private final Calendar calendar;
    private final Printer printer;
    private TransactionRepository transactionRepository;
    private Console console;

    public Account(Calendar calendar, Printer printer) {
        this.calendar = calendar;
        this.printer = printer;
    }

    public Account(Calendar calendar, Printer printer, TransactionRepository transactionRepository, Console console) {
        this.calendar = calendar;
        this.printer = printer;
        this.transactionRepository = transactionRepository;
        this.console = console;
    }

    public void deposit(int amount) {
        Transaction transaction = new Transaction(calendar.today(), amount);
        transactionRepository.save(transaction);
    }

    public void withdraw(int amount) {
        deposit(-amount);
    }

    public void printStatement() {
        Statement statement = new Statement();

        List<Transaction> transactions = transactionRepository.list();
        int balance = 0;
        for (Transaction transaction : transactions) {
            statement.lines.add(new StatementLine(
                    transaction.getOperationDate(),
                    transaction.getAmount(),
                    balance += transaction.getAmount()
            ));
        }

        console.print(statement);
    }
}
