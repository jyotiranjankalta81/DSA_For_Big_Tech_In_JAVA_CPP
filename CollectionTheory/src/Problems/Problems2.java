package Problems;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problems2 {

    public static String ListStringToString (List<String> str){
        String newString ="";

        newString = str.stream().collect(Collectors.joining(","));
        return newString;
    }


    record Order(
            int id,
            String product,
            double amount
    ) {}
   private record Employee (
        int id,
         String name,
         int salary,
         String department){}

    public static Map<String, Optional<Employee>> employeeSalaryDepartmentWise(List<Employee>employee){


        Map<String, Optional<Employee>>   employeesDepartmentWise = employee.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::salary))));
        return employeesDepartmentWise;

    }


    public static void main (String[] args) {
        List<String> PS1 = Arrays.asList("1", "2", "3", "4");
        System.out.println("String List to Single String " + ListStringToString(PS1));


        List<Employee> employees = List.of(
                new Employee(129, "Bharat", 30000, "IT"),
                new Employee(149, "Robin", 10000, "HR"),
                new Employee(159, "Kaish", 20000, "IT"),
                new Employee(169, "Kamra", 40000, "CSE"),
                new Employee(189, "Dibya", 50000, "IT")
        );

        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        List<Order> orders = List.of(
                new Order(1, "Laptop", 50000),
                new Order(2, "Phone", 20000),
                new Order(3, "Mouse", 1000),
                new Order(4, "Keyboard", 2000)
        );

        List<String> names = List.of("Ram", "Robin", "Krishna", "Rubik");

        List<Integer> elements = Arrays.asList(1,2,3,4,5,6,7,8,1,2,3,4,1,2,3,4);

        System.out.println("Department wise Salary " + employeeSalaryDepartmentWise(employees));

        System.out.println("Department wise Count " + employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting())));


        System.out.println("Flat map to normal Map ----> " + numbers.stream().flatMap(List::stream).toList());
        System.out.println("Comma separated String ----> " + names.stream().collect(Collectors.joining(",")));

        System.out.println("Partation emplyoee into two groups  ------> " + employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 10000)));

        double totalRevenue = orders.stream()
                .mapToDouble(Order::amount)
                .sum();

        System.out.println("Total revenue "+totalRevenue);

        double totalrevenue = orders.stream().map(Order::amount).reduce(0.0,Double::sum);

        System.out.println("total revenue-----> " + totalrevenue);

        System.out.println("Average Salary department Wise-------------> " + employees.stream().collect(Collectors.groupingBy(Employee::department)));


        //remove duplicate elements
        System.out.println("remove duplicate elments--------------> " +elements.stream().distinct().collect(Collectors.toList()) );

        //find duplicates
        System.out.println("find duplicates-----------> "  + elements.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry:: getKey).collect(Collectors.toList()));

        //second highest elemnt
        System.out.println("sorted decreasing order elments--------------> " +elements.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst() );
        //second highest by using max exclusion
        int max = elements.stream()
                .max(Integer::compareTo)
                .orElseThrow();

        int second = elements.stream()
                .filter(n -> n < max)
                .max(Integer::compareTo)
                .orElseThrow();

        System.out.println("second highest element -----> " + second);


        //find common elements in two lists

        List<Integer> list1 =
                Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> list2 =
                Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> common = list1.stream().filter(list2::contains).distinct().collect(Collectors.toList());



        System.out.println("Common elements between to lists--------------------->" + common);



    }
}
