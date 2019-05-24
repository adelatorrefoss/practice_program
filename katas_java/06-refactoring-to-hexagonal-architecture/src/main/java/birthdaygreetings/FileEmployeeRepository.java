package birthdaygreetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {

    private String fileName;

    public FileEmployeeRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> listEmployees() throws IOException, ParseException {
        List<Employee> employeeList = new ArrayList<>();
        String str;
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        in.readLine(); // skip header file
        while ((str = in.readLine()) != null) {
            String[] employeeData = parseEmployeeData(str);
            Employee employee = createEmployeeFromData(employeeData);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public List<Employee> listBirthdayEmployee(OurDate currentDate)  throws IOException, ParseException {
        List<Employee> employeeList = new ArrayList<>();
        String str;
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        in.readLine(); // skip header file
        while ((str = in.readLine()) != null) {
            String[] employeeData = parseEmployeeData(str);
            Employee employee = createEmployeeFromData(employeeData);
            if (employee.isBirthday(currentDate)) {
                employeeList.add(employee);
            }
        }

        return employeeList;
    }

    private Employee createEmployeeFromData(String[] employeeData) throws ParseException {


        return new Employee(employeeData[1], employeeData[0],
                employeeData[2], employeeData[3], null);
    }

    private String[] parseEmployeeData(String str) {
        return str.split(", ");
    }
}
