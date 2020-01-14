package bank;

import java.util.ArrayList;
import java.util.Objects;

public class Statement {
    public ArrayList lines = new ArrayList();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(lines, statement.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "lines=" + lines +
                '}';
    }
}
