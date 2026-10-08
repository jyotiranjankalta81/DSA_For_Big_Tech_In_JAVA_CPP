package Problems;

import java.util.*;
import java.util.stream.Collectors;

public class HighestPaidInEachDepartment {

    private record Employee(int id,String name,int salary,String department){

    }

    public static List<Employee> morethanAverageSalary(List<Employee> employees){

        Double aboveAverage = employees.stream().collect(Collectors.averagingInt(Employee::salary));
        List<Employee> employees1= employees.stream().filter(e->e.salary()>aboveAverage).toList();
        return employees1;


    }

    public static Map<String,Optional<Employee>> highestRankEmployees(List<Employee>employees){
        Map<String,Optional<Employee>> highestRankDeptWise = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::id))));
        return  highestRankDeptWise;
    }

    public static List<Employee> sortBasedOnNameAndDepartment(List<Employee> employees){
        List<Employee> sortedEmployees = employees.stream()
                .sorted(
                        Comparator.comparing(Employee::name)
                                .thenComparing(Employee::department)
                )
                .toList();

        return sortedEmployees;
    }



    public static void main (String [] args){

        List<Employee> employeeList = List.of(
                new Employee(1,"robin",7000,"HR"),
                new Employee(2,"resma",1000,"IT"),
                new Employee(3,"ali",2000,"HR"),
                new Employee(4,"palveer",3000,"HR"),
                new Employee(5,"ruskin",4000,"IT"),
                new Employee(6,"sheyam",5000,"HR"),
                new Employee(7,"prem",6000,"CLOUDE")
        );

//        Highest PaidEmploye in Each Department
//        Map<String, Optional< Employee>> highestPaidEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::salary))));

//        System.out.println("highest paid employee " + highestPaidEmployee);

//        System.out.println("morethan average  paid employee " + morethanAverageSalary(employeeList));

//        System.out.println("highest rank employee " + highestRankEmployees(employeeList));
//                System.out.println("sort employee based on name and department" + sortBasedOnNameAndDepartment(employeeList));

//                List<Employee> highestsalary = employeeList.stream().max(Comparator.comparing(Employee::salary)).stream().toList();
//                System.out.println("higgest paid employees " + highestsalary);


    }

}
