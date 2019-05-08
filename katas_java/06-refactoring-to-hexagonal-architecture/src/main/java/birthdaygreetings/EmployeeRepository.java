package birthdaygreetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> listEmployees() throws IOException, ParseException;
    List<Employee> listBirthdayEmployee(OurDate currentDate) throws IOException, ParseException;
}
