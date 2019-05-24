package birthdaygreetings.test;

import static org.junit.Assert.*;

import birthdaygreetings.Employee;
import birthdaygreetings.OurDate;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        String birthDate = "1990/01/31";
        String[] dateSplitted = birthDate.split("/");
        Date newBirthDate = new Date(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1]) - 1, Integer.parseInt(dateSplitted[2]));

        Employee employee = new Employee("foo", "bar", "a@b.c", newBirthDate);
        String date = "2008/01/30";
        assertFalse("not his birthday",
                employee.isBirthday(createDate(date)));
        String date2 = "2008/01/31";
        assertTrue("his birthday",
                employee.isBirthday(createDate(date2)));
    }

    @Test
    public void equality() throws Exception {
        String birthDate = "1999/09/01";
        String[] dateSplitted = birthDate.split("/");
        Date newBirthDate = new Date(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1]) - 1, Integer.parseInt(dateSplitted[2]));

        Employee base = new Employee("First", "Last",
                "first@last.com", newBirthDate);
        Employee same = new Employee("First", "Last",
                "first@last.com", newBirthDate);
        Employee different = new Employee("First", "Last",
                "boom@boom.com", newBirthDate);

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }

    private OurDate createDate(String date) throws ParseException {
        String[] dateSplitted = date.split("/");
        return new OurDate(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(dateSplitted[2]));
    }
}
