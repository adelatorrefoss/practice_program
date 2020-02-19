package alert_service;

public class UnusualSpendingsNotifierService {

  private PaymentRepository paymentRepository;
  private UserRepository userRepository;
  private DateProvider dateProvider;
  private AlertSender alertSender;
  private UnusualSpendingsDetector unusualSpendingDetector;
  private Notifier notifier;

  public UnusualSpendingsNotifierService(PaymentRepository paymentRepository, UserRepository userRepository, DateProvider dateProvider,
      AlertSender alertSender) {

    this.paymentRepository = paymentRepository;
    this.userRepository = userRepository;
    this.dateProvider = dateProvider;
    this.alertSender = alertSender;
  }

  public UnusualSpendingsNotifierService(UnusualSpendingsDetector unusualSpendingDetector, Notifier notifier) {

    this.unusualSpendingDetector = unusualSpendingDetector;
    this.notifier = notifier;
  }

  public void alertOfUnusualSpendings(int userId) {
    UnusualExpenses expenses = unusualSpendingDetector.execute(userId);

    if(expenses.isEmpty()) {
      return;
    }

    notifier.send(expenses);
  }
}
