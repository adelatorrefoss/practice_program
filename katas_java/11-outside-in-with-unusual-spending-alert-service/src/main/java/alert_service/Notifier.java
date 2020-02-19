package alert_service;

public interface Notifier {
    void send(UnusualExpenses unusualExpenses);
}
