package birthdaygreetings.test;

import static org.junit.Assert.*;

import birthdaygreetings.Employee;
import birthdaygreetings.OurDate;

import org.junit.Test;

import java.text.ParseException;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", "1990/01/31", "a@b.c");
        String date = "2008/01/30";
        assertFalse("not his birthday",
                employee.isBirthday(createDate(date)));
        String date2 = "2008/01/31";
        assertTrue("his birthday",
                employee.isBirthday(createDate(date2)));
    }

    @Test
    public void equality() throws Exception {
        Employee base = new Employee("First", "Last", "1999/09/01",
                "first@last.com");
        Employee same = new Employee("First", "Last", "1999/09/01",
                "first@last.com");
        Employee different = new Employee("First", "Last", "1999/09/01",
                "boom@boom.com");

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }

    private OurDate createDate(String date) throws ParseException {
        String[] dateSplitted = date.split("/");
        return new OurDate(null, Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(dateSplitted[2]));
    }
}
