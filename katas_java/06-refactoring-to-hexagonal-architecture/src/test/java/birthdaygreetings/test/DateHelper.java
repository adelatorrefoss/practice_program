package birthdaygreetings.test;

import birthdaygreetings.OurDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static OurDate createOurDate(String date) throws ParseException {
        return new OurDate(createDate(date));
    }

    public static Date createDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy/MM/dd").parse(date);
    }
}
