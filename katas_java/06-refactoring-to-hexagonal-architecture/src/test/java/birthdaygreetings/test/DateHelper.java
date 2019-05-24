package birthdaygreetings.test;

import birthdaygreetings.OurDate;

import java.text.ParseException;
import java.util.Date;

public class DateHelper {
    public static OurDate createOurDate(String date) throws ParseException {
        String[] dateSplitted = date.split("/");
        return new OurDate(new Date(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1])-1, Integer.parseInt(dateSplitted[2])));
    }


}
