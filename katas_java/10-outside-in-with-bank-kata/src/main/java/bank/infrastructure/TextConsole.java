package bank.infrastructure;

import bank.Console;
import bank.Statement;

public class TextConsole implements Console {
    private Printer printer;

    public TextConsole(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(Statement statement) {
        printer.print("XXX");
    }
}
