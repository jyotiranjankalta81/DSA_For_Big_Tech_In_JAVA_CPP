package Problems;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    private record Employee(int id,String name,int salary,String department){

    }
    public static Map<String, List<String>> employeeDepartmentWise(
            List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.mapping(Employee::name,Collectors.toList())));
    }

    public static void main (String[] args) {

        List<Employee> employees = List.of(
                new Employee(129, "Bharat", 30000, "IT"),
                new Employee(149, "Robin", 10000, "HR"),
                new Employee(159, "Kaish", 20000, "IT"),
                new Employee(169, "Kamra", 40000, "CSE"),
                new Employee(189, "Dibya", 50000, "IT")
        );

//        System.out.println("Department wise Salary " + employeeDepartmentWise(employees));


        int [] fib ={0,1};
        Stream.iterate(fib,f->new int[]{f[1],f[0]+f[1]})
                .limit(20)
                .map(f->f[0])
                .forEach(System.out::println);
    }
}
