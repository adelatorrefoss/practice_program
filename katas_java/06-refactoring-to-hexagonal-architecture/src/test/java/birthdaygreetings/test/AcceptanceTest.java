package birthdaygreetings.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;

import birthdaygreetings.BirthdayService;
import birthdaygreetings.EmployeeRepository;
import birthdaygreetings.FileEmployeeRepository;
import birthdaygreetings.OurDate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcceptanceTest {

    private static final int SMTP_PORT = 25;
    private List<Message> messagesSent;
    private BirthdayService service;

    @Before
    public void setUp() throws Exception {
        messagesSent = new ArrayList<Message>();

        EmployeeRepository employeeRepository = new FileEmployeeRepository("src/test/resources/employee_data.txt");

        service = new BirthdayService(employeeRepository) {
            @Override
            protected void sendMessage(Message msg) throws MessagingException {
                messagesSent.add(msg);
            }
        };
    }

    @Test
    public void baseScenario() throws Exception {

        String date = "2008/10/08";
        service.sendGreetings(
                createDate(date), "localhost", SMTP_PORT);

        assertEquals("message not sent?", 1, messagesSent.size());
        Message message = messagesSent.get(0);
        assertEquals("Happy Birthday, dear John!", message.getContent());
        assertEquals("Happy Birthday!", message.getSubject());
        assertEquals(1, message.getAllRecipients().length);
        assertEquals("john.doe@foobar.com",
                message.getAllRecipients()[0].toString());
    }

    @Test
    public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
        String date = "2008/01/01";
        service.sendGreetings(
                createDate(date), "localhost", SMTP_PORT);

        assertEquals("what? messages?", 0, messagesSent.size());
    }

    private OurDate createDate(String date) throws ParseException {
        String[] dateSplitted = date.split("/");
        return new OurDate(new Date(Integer.parseInt(dateSplitted[0]), Integer.parseInt(dateSplitted[1])-1, Integer.parseInt(dateSplitted[2])));
    }
}
