package alert_service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MonthlyUnusualExpensesDetector implements UnusualSpendingsDetector {
    private final DateProvider dateProvider;
    private final PaymentRepository paymentRepository;

    public MonthlyUnusualExpensesDetector(DateProvider dateProvider, PaymentRepository paymentRepository) {

        this.dateProvider = dateProvider;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public UnusualExpenses execute(int userId) {

        Date currentMonth = dateProvider.currentMonth();
        Date previousMonth = dateProvider.previousMonth();

        List<Payment> currentMonthPayments = paymentRepository.getPaymentsByMonth(userId, currentMonth);
        List<Payment> previousMonthPayments = paymentRepository.getPaymentsByMonth(userId, previousMonth);

        return new UnusualExpenses(userId, Arrays.asList());
    };
}
