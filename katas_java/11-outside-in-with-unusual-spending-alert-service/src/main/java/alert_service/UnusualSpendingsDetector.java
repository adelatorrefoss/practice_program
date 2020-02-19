package alert_service;

public interface UnusualSpendingsDetector {
    UnusualExpenses execute(int userId);
}
