package alert_service;

import java.util.Date;
import java.util.List;

public interface PaymentRepository {

  public List<Payment> getPaymentsByMonth(int userId, Date date);
}
