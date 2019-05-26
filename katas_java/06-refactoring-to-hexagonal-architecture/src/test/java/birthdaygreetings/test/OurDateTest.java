package birthdaygreetings.test;

import birthdaygreetings.OurDate;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class OurDateTest {
    @Test
    public void getters() throws Exception {
        String date = "1789/01/24";
        OurDate ourDate = DateHelper.createOurDate(date);
        assertEquals(1, ourDate.getMonth());
        assertEquals(24, ourDate.getDay());
    }

    @Test
    public void isSameDate() throws Exception {
        String date = "1789/01/24";
        OurDate ourDate = DateHelper.createOurDate(date);
        String date2 = "2001/01/24";
        OurDate sameDay = DateHelper.createOurDate(date2);
        String date3 = "1789/01/25";
        OurDate notSameDay = DateHelper.createOurDate(date3);
        String date4 = "1789/02/25";
        OurDate notSameMonth = DateHelper.createOurDate(date4);

        assertTrue("same", ourDate.isSameDay(sameDay));
        assertFalse("not same day", ourDate.isSameDay(notSameDay));
        assertFalse("not same month", ourDate.isSameDay(notSameMonth));
    }

    @Test
    public void equality() throws Exception {
        String date = "2000/01/02";
        OurDate base = DateHelper.createOurDate(date);
        OurDate same = DateHelper.createOurDate(date);
        OurDate different = DateHelper.createOurDate("2000/01/04");

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(base));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }

    @Test
    public void new_constructor() throws Exception {
        OurDate ourDate = new OurDate(new SimpleDateFormat("yyyy/MM/dd").parse("1789/01/24"));
        assertEquals(1, ourDate.getMonth());
        assertEquals(24, ourDate.getDay());
    }
}
