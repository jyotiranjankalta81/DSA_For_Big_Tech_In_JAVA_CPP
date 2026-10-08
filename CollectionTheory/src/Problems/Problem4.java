package Problems;

import  java.util.*;
import java.util.stream.Collectors;


/*
Given List<Employee>, find the top 2 highest-paid employees in each department,
 but ignore duplicate salaries. If two employees have the same salary, break ties by name.
 */
public class Problem4 {
    private record Employee(int id,String name,int salary,String department){

    }
    public static   Map<String,Optional<Employee>> TopSecondHighestPaidEachDepartment(List<Employee> employees){


        Map<String, Optional<Employee>> secondHighestDistinctEachDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        departmentEmployees -> {
                                            int highestSalary = departmentEmployees.stream()
                                                    .map(Employee::salary)
                                                    .max(Integer::compareTo)
                                                    .orElseThrow();

                                            return departmentEmployees.stream()
                                                    .filter(employee ->
                                                            employee.salary() < highestSalary)
                                                    .max(Comparator.comparing(Employee::salary));
                                        }
                                )
                        ));


        return secondHighestDistinctEachDepartment;
    }



    public static void main(String[] args ){

        List<Employee> employees = List.of(
                new Employee(1,"robin",1000,"HR"),
                new Employee(1,"rest",2000,"IT"),
                new Employee(1,"ali",3000,"HR"),
                new Employee(1,"paler",4000,"HR"),
                new Employee(1,"ruskin",5000,"IT"),
                new Employee(1,"shame",6000,"HR"),
                new Employee(1,"prem",7000,"CLOUD")



        );




        System.out.println("TopSecondHighestPaidEachDepartment  " + TopSecondHighestPaidEachDepartment(employees));

    }

}
