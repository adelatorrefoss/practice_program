package birthdaygreetings.test;

import static org.junit.Assert.*;

import birthdaygreetings.OurDate;

import org.junit.Test;

import java.text.ParseException;

public class OurDateTest {
    @Test
    public void getters() throws Exception {
        String date = "1789/01/24";
        OurDate ourDate = createDate(date);
        assertEquals(1, ourDate.getMonth());
        assertEquals(24, ourDate.getDay());
    }

    @Test
    public void isSameDate() throws Exception {
        String date = "1789/01/24";
        OurDate ourDate = createDate(date);
        String date2 = "2001/01/24";
        OurDate sameDay = createDate(date2);
        String date3 = "1789/01/25";
        OurDate notSameDay = createDate(date3);
        String date4 = "1789/02/25";
        OurDate notSameMonth = createDate(date4);

        assertTrue("same", ourDate.isSameDay(sameDay));
        assertFalse("not same day", ourDate.isSameDay(notSameDay));
        assertFalse("not same month", ourDate.isSameDay(notSameMonth));
    }

    @Test
    public void equality() throws Exception {
        String date = "2000/01/02";
        OurDate base = createDate(date);
        OurDate same = createDate(date);
        OurDate different = createDate("2000/01/04");

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(base));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }

    private OurDate createDate(String date) throws ParseException {
        String[] dateSplitted = date.split("/");
        return new OurDate(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1]), Integer.parseInt(dateSplitted[2]));
    }

    @Test
    public void new_constructor() throws Exception {
        OurDate ourDate = new OurDate(1789, 01, 24);
        assertEquals(1, ourDate.getMonth());
        assertEquals(24, ourDate.getDay());
    }
}
