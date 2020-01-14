package bank.infrastructure;

import bank.Console;
import bank.Statement;
import bank.StatementLine;

import java.text.SimpleDateFormat;
import java.util.Collections;

import static java.lang.Math.abs;

public class TextConsole implements Console {
    private Printer printer;

    public TextConsole(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(Statement statement) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("date || credit || debit || balance\n");

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Collections.reverse(statement.lines);

        for (StatementLine statementLine : statement.lines) {
            String date = simpleDateFormat.format(statementLine.operationDate);
            String credit = "";
            String debit = "";
            String amount = String.valueOf(abs(statementLine.amount));
            if (statementLine.amount >= 0) {
                credit = " " + amount;
            } else {
                debit = " " + amount;
            }
            stringBuffer.append(date +
                    " ||" +
                    credit +
                    " ||" +
                    debit +
                    " || " +
                    statementLine.balance +
                    "\n");
        }

        printer.print(stringBuffer.toString());
    }
}
