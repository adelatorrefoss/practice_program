package alert_service;

import java.util.List;
import java.util.Objects;

public class UnusualExpenses {
    private int userId;
    private List<UnusualSpending> unusualSpendings;

    public UnusualExpenses(int userId, List<UnusualSpending> unusualSpendings) {
        this.userId = userId;
        this.unusualSpendings = unusualSpendings;
    }

    public boolean isEmpty() {
        return unusualSpendings.isEmpty();
    }

    @Override
    public String toString() {
        return "UnusualExpenses{" +
                "userId=" + userId +
                ", unusualSpendings=" + unusualSpendings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnusualExpenses that = (UnusualExpenses) o;
        return userId == that.userId &&
                unusualSpendings.equals(that.unusualSpendings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, unusualSpendings);
    }
}
