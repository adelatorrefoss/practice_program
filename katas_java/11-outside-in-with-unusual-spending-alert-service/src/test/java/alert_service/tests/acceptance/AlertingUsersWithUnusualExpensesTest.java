package alert_service.tests.acceptance;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alert_service.AlertSender;
import alert_service.DateProvider;
import alert_service.Notification;
import alert_service.Payment;
import alert_service.PaymentRepository;
import alert_service.UnusualSpendingsNotifierService;
import alert_service.User;
import alert_service.UserRepository;

public class AlertingUsersWithUnusualExpensesTest {

    @Test
    public void alerting_users_with_unusual_spendings_in_some_categories() {
        int userId = 100;
        String email = "user@mail.com";
        User recipient = new User(userId, email);
        Date januaryDate = Date.valueOf("2020-01-31");
        Date decemberDate = Date.valueOf("2020-12-31");
        List<Payment> januaryPayments = Arrays.asList(
                new Payment("Gasolina", 30, Date.valueOf("2019-12-20")),
                new Payment("Alimentacion", 120, Date.valueOf("2019-12-15")),
                new Payment("Frutos secos", 10, Date.valueOf("2019-12-01"))
        );
        List<Payment> decemberPayments = Arrays.asList(
                new Payment("Gasolina", 40, Date.valueOf("2020-01-01")),
                new Payment("Gasolina", 50, Date.valueOf("2020-01-10")),
                new Payment("Alimentacion", 80, Date.valueOf("2020-01-15")),
                new Payment("Frutos secos", 30, Date.valueOf("2020-01-01"))
        );

        PaymentRepository paymentRepository = mock(PaymentRepository.class);
        when(paymentRepository.getPaymentsByMonth(userId, decemberDate)).thenReturn(decemberPayments);
        when(paymentRepository.getPaymentsByMonth(userId, januaryDate)).thenReturn(januaryPayments);

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.find(userId)).thenReturn(recipient);

        DateProvider dateProvider = mock(DateProvider.class);
        when(dateProvider.currentMonth()).thenReturn(januaryDate);
        when(dateProvider.previousMonth()).thenReturn(decemberDate);

        AlertSender alertSender = mock(AlertSender.class);

        UnusualSpendingsNotifierService unusualSpendingsNotifierService =
                new UnusualSpendingsNotifierService(paymentRepository, userRepository, dateProvider, alertSender);
        unusualSpendingsNotifierService.alertOfUnusualSpendings(userId);

        String subject = "Unusual spending of $120 detected!";
        String content = "Hello card user!\n"
                + "\n"
                + "We have detected unusually high spending on your card in these categories:\n"
                + "\n"
                + "* You spent $90 on Gasolina\n"
                + "* You spent $30 on Frutos secos\n"
                + "\n"
                + "Love,\n"
                + "\n"
                + "The Credit Card Company\n";
        verify(alertSender).send(new Notification(subject, content, recipient));
    }
}
