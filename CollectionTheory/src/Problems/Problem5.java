package Problems;
import  java.util.*;
import java.util.stream.Collectors;


/*
Given employees with department, salary, and joiningDate,
 find the most recently joined employee among the highest-paid employees of each department.
 */
public class Problem5 {
    private record Employee(int id,String name,int salary,String department, String joining_date){

    }



    public static void main (String[] args){
        List<Employee> employees = List.of(
                new Employee(1,"robin",6000,"HR","20-08-2025"),
                new Employee(2,"ali",6000,"HR","21-08-2025"),
                new Employee(3,"paler",6000,"HR","22-08-2025"),
                new Employee(4,"shame",6000,"HR","21-08-2025"),
                new Employee(5,"rest",6000,"IT","21-08-2025"),
                new Employee(6,"ruskin",6000,"IT","20-08-2025"),
                new Employee(7,"prem",6000,"CLOUD","20-08-2025")
        );

        Map<String,Optional<Employee>> recentjoinwithhighpay = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.collectingAndThen(
                        Collectors.toList(),
                        departmentEmployee->
                            departmentEmployee.stream()
                                    .sorted(
                                            Comparator.comparing(Employee::salary)
                                                    .reversed()
                                    ).min(Comparator.comparing(Employee::joining_date))
                )));

        System.out.println("recentjoinwithhighpay " + recentjoinwithhighpay);
    }


}
