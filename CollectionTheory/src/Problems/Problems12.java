package Problems;
import java.util.*;
import java.util.stream.Collectors;

public class Problems12 {

    /*
    Given employees, create:
Map<String, Map<String, List<Employee>>>

where:

department
    -> salaryBand
         -> employees

Salary bands:

LOW    < 20000
MEDIUM 20000-50000
HIGH   > 50000

     */



    record Employee(
            int id,
            String name,
            String department,
            int salary
    ) {}

    public static void main (String [] args) {


        List<Employee> employees = List.of(
                new Employee(1, "Robin", "IT", 18000),
                new Employee(2, "Ali", "IT", 20000),
                new Employee(3, "Paler", "IT", 35000),
                new Employee(4, "Shane", "IT", 50000),
                new Employee(5, "Prem", "IT", 75000),

                new Employee(6, "Ruskin", "HR", 15000),
                new Employee(7, "Neha", "HR", 28000),
                new Employee(8, "Rahul", "HR", 45000),
                new Employee(9, "Priya", "HR", 60000),

                new Employee(10, "Amit", "Finance", 19000),
                new Employee(11, "Kiran", "Finance", 32000),
                new Employee(12, "Meera", "Finance", 50000),
                new Employee(13, "Vikram", "Finance", 90000),

                new Employee(14, "Anita", "Sales", 12000),
                new Employee(15, "Rohit", "Sales", 25000),
                new Employee(16, "Pooja", "Sales", 48000),
                new Employee(17, "Deepak", "Sales", 55000),

                new Employee(18, "Kavya", "Support", 17000),
                new Employee(19, "Manoj", "Support", 30000),
                new Employee(20, "Divya", "Support", 52000)
        );





        Map<String, Map<String, List<Employee>>> nestedDepartmentWise =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.groupingBy(
                                        employee -> {
                                            if (employee.salary() < 20000) {
                                                return "LOW";
                                            } else if (employee.salary() <= 50000) {
                                                return "MEDIUM";
                                            } else {
                                                return "HIGH";
                                            }
                                        }
                                )
                        ));


        System.out.println("nestedDepartmentWise " + nestedDepartmentWise);
    }
}
