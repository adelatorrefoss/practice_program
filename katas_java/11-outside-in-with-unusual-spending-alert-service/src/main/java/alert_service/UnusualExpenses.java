package alert_service;

import java.util.List;

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
}
