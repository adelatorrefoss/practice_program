package alert_service;

import java.util.Date;

public interface DateProvider {

  Date currentMonth();

  Date previousMonth();
}
