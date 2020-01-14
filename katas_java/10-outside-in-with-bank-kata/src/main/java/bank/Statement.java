package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Statement {
    List lines = new ArrayList();

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
}
