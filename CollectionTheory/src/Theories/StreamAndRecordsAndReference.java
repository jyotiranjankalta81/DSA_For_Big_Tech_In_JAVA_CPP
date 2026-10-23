package Theories;

import  java.util.*;
import java.util.stream.*;
import  java.util.function.*;

public class StreamAndRecordsAndReference {


    record Employees(int id,String name,int salary,String department){

    }

    public static void main (String[] args){
        List<Employees> employess = Arrays.asList(new Employees(1,"Rom",50000,"HR"),
                new Employees(1,"Romya",30000,"IT"),
                new Employees(1,"Romha",20000,"HR"),
                new Employees(1,"Romrd",10000,"CSE"),
                new Employees(1,"Romkb",70000,"OOP"),
                new Employees(1,"Romrv",90000,"HR"),
                new Employees(1,"Romoi",80000,"IT"));

        List <Integer> numbers = Arrays.asList(10,10,30,40,50,60,70,80);

//        filter

        List<Employees> filterEmployee = employess.stream().filter(e->e.salary>20000).collect(Collectors.toList());
//        System.out.println("filterEmployees  " + filterEmployee);

//        map
        List<String> employeesMap = employess.stream().map(Employees::department).collect(Collectors.toList());
//        System.out.println("employess department list " + employeesMap);


//        flatMap
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );

        List<Integer> flatten = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());

//        System.out.println("flatten the list " + flatten);

//        distinct

        List<Integer> distinctelement = numbers.stream().distinct().collect(Collectors.toList());
//        System.out.println("distinctnumber " + distinctelement);

//        Sorted

        List<Integer> sortedelement = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println("sorted element " + sortedelement);

//        sorted reverse order

        List<String> sortedInReverse = employess.stream().sorted(Comparator.comparing(Employees::salary).reversed()).map(Employees::name).collect(Collectors.toList());

//        System.out.println("Employee in decending order " + sortedInReverse);


//        limit

        List<Employees> limitEmployee = employess.stream().limit(1).collect(Collectors.toList());
//        System.out.println("limited Employees " + limitEmployee);

//        skip

        List<String> skipfew = employess.stream().sorted(Comparator.comparing(Employees::salary)).skip(2).map(Employees::name).collect(Collectors.toList());
//        System.out.println("skip few from list  " + skipfew);

        //groupingBy
        Map<String,List<Employees>> groupEmployee = employess.stream().collect(Collectors.groupingBy(Employees::department));

//        System.out.println("group employees " + groupEmployee);

        //groupingBy and counting
        Map<String,Long> groupEmployeecounting = employess.stream().collect(Collectors.groupingBy(Employees::department,Collectors.counting()));
//        System.out.println("groupBy and Counting " + groupEmployeecounting);

        //groupingBy and maxSalary
        Map<String,Optional<Employees>> groupEmployeeMaxsalary = employess.stream().collect(Collectors.groupingBy(Employees::department,Collectors.maxBy(Comparator.comparing(Employees::salary))));
//        System.out.println("groupBy and Salary max by " + groupEmployeeMaxsalary);


        //groupingBy and minSalary
        Map<String,Optional<Employees>> groupEmployeeminsalary = employess.stream().collect(Collectors.groupingBy(Employees::department,Collectors.minBy(Comparator.comparing(Employees::salary))));

        //groupingBy and salary department wise
        Map<String,Integer> groupdepartmentwisesalarysum = employess.stream().collect(Collectors.groupingBy(Employees::department,Collectors.summingInt(Employees::salary)));
//        System.out.println("all the summing salary " + groupdepartmentwisesalarysum);


        //groupingBy and average salary department wise
        Map<String,Double> groupdepartmentaveragewisesalarysum = employess.stream().collect(Collectors.groupingBy(Employees::department,Collectors.averagingInt(Employees::salary)));
        System.out.println("all the summing salary " + groupdepartmentaveragewisesalarysum);

        Integer total = numbers.stream()
                .reduce(0, Integer::sum);

















    }




}
