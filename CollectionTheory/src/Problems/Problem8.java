package Problems;

import java.util.*;
import java.util.stream.Collectors;

public class Problem8 {

    /*

    Given employees and a list of projects:
record Employee(int id, String name, List<Project> projects) {}
record Project(String name, int hours) {}

find the employee who has worked the maximum total project hours.
     */



    private record Employee(int id, String name, List<Project> projects) {}
    private record Project(String name, int hours) {}


    public static void main (String [] args){
        List<Employee> employees = List.of(
                new Employee(
                        1,
                        "Robin",
                        List.of(
                                new Project("Banking System", 120),
                                new Project("Payment Gateway", 80),
                                new Project("Notification Service", 45)
                        )
                ),
                new Employee(
                        2,
                        "Ali",
                        List.of(
                                new Project("E-Commerce Platform", 150),
                                new Project("Inventory Service", 70)
                        )
                ),
                new Employee(
                        3,
                        "Paler",
                        List.of(
                                new Project("Banking System", 90),
                                new Project("Fraud Detection", 110)
                        )
                ),
                new Employee(
                        4,
                        "Shane",
                        List.of(
                                new Project("Payment Gateway", 100),
                                new Project("Order Service", 60),
                                new Project("Inventory Service", 40)
                        )
                ),
                new Employee(
                        5,
                        "Prem",
                        List.of(
                                new Project("E-Commerce Platform", 130),
                                new Project("Notification Service", 50)
                        )
                ),
                new Employee(
                        6,
                        "Ruskin",
                        List.of(
                                new Project("Fraud Detection", 95),
                                new Project("Banking System", 75),
                                new Project("Order Service", 55)
                        )
                ),
                new Employee(
                        7,
                        "Neha",
                        List.of(
                                new Project("Inventory Service", 85),
                                new Project("Payment Gateway", 65)
                        )
                ),
                new Employee(
                        8,
                        "Rahul",
                        List.of(
                                new Project("Order Service", 90),
                                new Project("E-Commerce Platform", 100),
                                new Project("Notification Service", 35)
                        )
                ),
                new Employee(
                        9,
                        "Priya",
                        List.of(
                                new Project("Banking System", 105),
                                new Project("Fraud Detection", 70)
                        )
                ),
                new Employee(
                        10,
                        "Amit",
                        List.of()
                )
        );


        List<Map.Entry<String,Integer>> employeeworksHighHour = employees.stream()
                .collect(Collectors.groupingBy(Employee::name,Collectors.collectingAndThen(Collectors.toList(),
                        employeeProject->employeeProject.stream()
                                .flatMap(e->e.projects().stream()).collect(Collectors.summingInt(Project::hours)))
                        )).entrySet()
                .stream().sorted(Map.Entry.<String,Integer> comparingByValue().reversed())
                .limit(1)
                .toList();


        Optional<Map.Entry<String, Integer>> employeeWorksHighHour =
                employees.stream()
                        .map(employee -> Map.entry(
                                employee.name(),
                                employee.projects()
                                        .stream()
                                        .mapToInt(Project::hours)
                                        .sum()
                        ))
                        .max(Map.Entry.comparingByValue());


        System.out.println("employeeworksHighHour   " + employeeworksHighHour + " employeeWorksHighHour " + employeeWorksHighHour );
    }
}
