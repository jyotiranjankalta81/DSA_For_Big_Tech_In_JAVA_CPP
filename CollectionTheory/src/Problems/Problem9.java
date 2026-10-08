package Problems;
import  java.util.*;
import java.util.stream.Collectors;

public class Problem9 {

    /*

    Find the department with the largest salary variance:
max salary - min salary

Do this entirely using Streams.
     */


    record Employee(
            int id,
            String name,
            String department,
            int salary
    ) {}

    public static void main (String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Robin", "IT", 60000),
                new Employee(2, "Ali", "IT", 95000),
                new Employee(3, "Paler", "IT", 120000),
                new Employee(4, "Shane", "IT", 75000),

                new Employee(5, "Prem", "HR", 45000),
                new Employee(6, "Ruskin", "HR", 65000),
                new Employee(7, "Neha", "HR", 55000),

                new Employee(8, "Rahul", "Finance", 70000),
                new Employee(9, "Priya", "Finance", 140000),
                new Employee(10, "Amit", "Finance", 90000),
                new Employee(11, "Kiran", "Finance", 110000),

                new Employee(12, "Meera", "Sales", 40000),
                new Employee(13, "Vikram", "Sales", 85000),
                new Employee(14, "Anita", "Sales", 60000),

                new Employee(15, "Rohit", "Support", 50000),
                new Employee(16, "Pooja", "Support", 52000),
                new Employee(17, "Deepak", "Support", 51000)
        );

        Map<String,Optional<Employee>> maxofEachDepartment =
                employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::salary))));
        Map<String,Optional<Employee>> minofEachDepartment =
                employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.minBy(Comparator.comparing(Employee::salary))));

//        Map<String,Integer> calculateHighDiff= maxofEachDepartment.
    }
}
