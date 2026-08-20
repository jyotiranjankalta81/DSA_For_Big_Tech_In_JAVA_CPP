package Problems;

//Given a List<Employee>, use Streams to group employees by department and count
//them (groupingBy + counting).

import java.util.*;
import java.util.stream.Collectors;

public class Problems1 {

    public record Employee(
        int id,
        String name,
        String department,
        int salary

    ){

    };
    public static void main (String[] args){

        List<Employee> employees = List.of(new Employee(1,"robin","HR",5000),

                new Employee(1,"resma","IT",8000),
                new Employee(1,"ali","HR",5000),
                new Employee(1,"palveer","HR",5000),
                new Employee(1,"ruskin","IT",5000),
                new Employee(1,"sheyam","HR",5000),
                new Employee(1,"prem","CLOUDE",5000)



                );

        Map<String,Optional<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::salary))));

        Map<String,Long> result1 = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.counting()));

        System.out.println("result " + result1);
    }
}
