package alert_service.tests.unit;

import alert_service.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class UnusualExpensesNotifierServiceTest {

    public static final int USER_ID = 100;

    @Test
    public void should_not_send_any_notification_when_there_are_not_unusual_expenses() {
        int userId = USER_ID;
        UnusualSpendingsDetector unusualSpendingDetector = mock(MonthlyUnusualSpendingsDetector.class);
        Notifier notifier = mock(TextMessageNotifier.class);
        when(unusualSpendingDetector.execute(userId)).thenReturn(new UnusualExpenses(userId,
                Collections.emptyList()
        ));

        UnusualSpendingsNotifierService unusualSpendingsNotifierService =
                new UnusualSpendingsNotifierService(unusualSpendingDetector, notifier);
        unusualSpendingsNotifierService.alertOfUnusualSpendings(userId);

        verify(notifier, never()).send(any());
    }

    @Test
    public void should_send_a_notification_when_there_are_unusual_expenses() {
        int userId = USER_ID;
        UnusualSpendingsDetector unusualSpendingDetector = mock(MonthlyUnusualSpendingsDetector.class);
        Notifier notifier = mock(TextMessageNotifier.class);
        double anyAmount = 1.0;
        String anyCategory = "AnyCategory";
        UnusualExpenses unusualExpenses = new UnusualExpenses(userId,
                Arrays.asList(new UnusualSpending(anyCategory, anyAmount)
                ));
        when(unusualSpendingDetector.execute(userId)).thenReturn(unusualExpenses);

        UnusualSpendingsNotifierService unusualSpendingsNotifierService =
                new UnusualSpendingsNotifierService(unusualSpendingDetector, notifier);
        unusualSpendingsNotifierService.alertOfUnusualSpendings(userId);

        verify(notifier, times(1)).send(unusualExpenses);
    }
}
