package alert_service.tests.unit;

import alert_service.*;
import org.junit.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class UnusualExpensesNotifierServiceTest {
    @Test
    public void should_not_send_any_notification_when_there_are_not_unusual_expenses() {
        int userId = 100;
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
}
