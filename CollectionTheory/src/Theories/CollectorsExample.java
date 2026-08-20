package Theories;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    record Employee(
            int id,
            String name,
            String department,
            double salary) {
    }

    public static void main(String[] args) {

        List<Employee> employees = List.of(

                new Employee(1, "John", "IT", 50000),

                new Employee(2, "Alice", "HR", 60000),

                new Employee(3, "Bob", "IT", 70000),

                new Employee(4, "David", "HR", 80000),

                new Employee(5, "Emma", "IT", 70000)
        );

        // toList()

        List<String> names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toList());

        System.out.println(names);

        // toSet()

        Set<String> departments = employees.stream()
                .map(Employee::department)
                .collect(Collectors.toSet());

        System.out.println(departments);

        // toMap()

        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::id,
                        Employee::name));

        System.out.println(employeeMap);

        // groupingBy()

        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department));

        System.out.println(grouped);

        // counting()

        Map<String, Long> count = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()));

        System.out.println(count);

        // averagingDouble()

        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(
                                Employee::salary)));

        System.out.println(averageSalary);

        // summingDouble()

        Map<String, Double> totalSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.summingDouble(
                                Employee::salary)));

        System.out.println(totalSalary);

        // maxBy()

        Optional<Employee> highestPaid = employees.stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(
                                Employee::salary)));

        System.out.println(highestPaid);

        // minBy()

        Optional<Employee> lowestPaid = employees.stream()
                .collect(Collectors.minBy(
                        Comparator.comparing(
                                Employee::salary)));

        System.out.println(lowestPaid);

        // partitioningBy()

        Map<Boolean, List<Employee>> partitioned =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                employee ->
                                        employee.salary() > 65000));

        System.out.println(partitioned);

        // joining()

        String joinedNames = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));

        System.out.println(joinedNames);

        // mapping()

        Map<String, List<String>> departmentNames =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.mapping(
                                        Employee::name,
                                        Collectors.toList())));

        System.out.println(departmentNames);

        // collectingAndThen()

        List<String> unmodifiableNames =
                employees.stream()
                        .map(Employee::name)
                        .collect(
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        Collections::unmodifiableList));

        System.out.println(unmodifiableNames);

        // groupingBy() + toSet()

        Map<String, Set<String>> departmentSet =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.mapping(
                                        Employee::name,
                                        Collectors.toSet())));

        System.out.println(departmentSet);

        // groupingBy() + toMap()

        Map<String, Map<Integer, String>> nestedMap =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.toMap(
                                        Employee::id,
                                        Employee::name)));

        System.out.println(nestedMap);

        // teeing() (Java 12)

        Double average = employees.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(
                                Employee::salary),

                        Collectors.counting(),

                        (sum, total) -> sum / total));

        System.out.println(average);

        // summarizingDouble()

        DoubleSummaryStatistics statistics =
                employees.stream()
                        .collect(Collectors.summarizingDouble(
                                Employee::salary));

        System.out.println(statistics);

        Map<String, Optional<Employee>> result =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,

                                        Collectors.maxBy(
                                                Comparator.comparing(
                                                        Employee::salary
                                                )
                                        )
                                )
                        );

        System.out.println(result);
    }
}