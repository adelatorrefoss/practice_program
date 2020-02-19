package alert_service.tests.unit;

import alert_service.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonthlyUnusualSpendingsDetectorTest {

    /**
     * No payments at all
     * No payments in current month
     * No payments in previous month
     * No unusual spending in one category
     * No unusual spending in many category
     * No unusual spending in one category and only one payment
     * No unusual spending in one category and many payments
     * Unusual spending
     */
    @Test
    public void should_return_empty_unusual_expenses_if_there_are_not_unusual_spending() {
        int userId = 100;
        Date januaryDate = Date.valueOf("2020-01-31");
        Date decemberDate = Date.valueOf("2020-12-31");
        List<Payment> januaryPayments = Arrays.asList(
                new Payment("Gasolina", 30, Date.valueOf("2019-12-20"))
        );
        List<Payment> decemberPayments = Arrays.asList(
                new Payment("Gasolina", 44, Date.valueOf("2020-01-01"))
        );

        DateProvider dateProvider = mock(DateProvider.class);
        when(dateProvider.currentMonth()).thenReturn(januaryDate);
        when(dateProvider.previousMonth()).thenReturn(decemberDate);

        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        when(paymentRepository.getPaymentsByMonth(userId, decemberDate)).thenReturn(decemberPayments);
        when(paymentRepository.getPaymentsByMonth(userId, januaryDate)).thenReturn(januaryPayments);


        UnusualSpendingsDetector detector = new MonthlyUnusualExpensesDetector(dateProvider, paymentRepository);

        UnusualExpenses result = detector.execute(userId);

        assertTrue(result.isEmpty());
    }

}