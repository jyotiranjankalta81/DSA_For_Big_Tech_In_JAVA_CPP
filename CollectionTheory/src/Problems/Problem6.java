package Problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;


/*
Given List<Order> where each order has customerId, amount, status, and createdAt,
 find the top 3 customers by total COMPLETED order value in the last 30 days.
 */
public class Problem6 {



    private record Employee(int customerId,String name,int amount,String status, LocalDate createdAt){

    }

    private static LocalDate date(String value) {
        return LocalDate.parse(
                value,
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
        );
    }



    public static void main (String[] args){
        List<Employee> employees = List.of(
                new Employee(1, "robin", 6000, "COMPLETED", date("02-08-2026")),
                new Employee(2, "ali", 7500, "IN_PROGRESS", date("05-08-2026")),
                new Employee(3, "paler", 8200, "COMPLETED", date("08-08-2026")),
                new Employee(4, "shane", 6800, "PENDING", date("10-08-2026")),
                new Employee(5, "rest", 9000, "COMPLETED", date("12-08-2026")),
                new Employee(6, "ruskin", 7200, "IN_PROGRESS", date("14-08-2026")),
                new Employee(7, "prem", 8500, "PENDING", date("16-08-2026")),
                new Employee(8, "amit", 10000, "COMPLETED", date("18-08-2026")),
                new Employee(9, "neha", 9500, "IN_PROGRESS", date("20-08-2026")),
                new Employee(10, "rahul", 11000, "COMPLETED", date("22-08-2026")),
                new Employee(11, "suman", 7800, "CANCELLED", date("24-08-2026")),
                new Employee(12, "priya", 10500, "COMPLETED", date("25-08-2026")),
                new Employee(13, "arjun", 8800, "IN_PROGRESS", date("27-08-2026")),
                new Employee(14, "kiran", 9200, "PENDING", date("29-08-2026")),
                new Employee(15, "meera", 11500, "COMPLETED", date("31-08-2026")),
                new Employee(16, "vikram", 12000, "IN_PROGRESS", date("01-09-2026")),
                new Employee(17, "anita", 7600, "COMPLETED", date("03-09-2026")),
                new Employee(18, "rohit", 8400, "PENDING", date("05-09-2026")),
                new Employee(19, "pooja", 9800, "COMPLETED", date("07-09-2026")),
                new Employee(20, "deepak", 10200, "IN_PROGRESS", date("09-09-2026")),
                new Employee(21, "kavya", 8900, "CANCELLED", date("11-09-2026")),
                new Employee(22, "manoj", 10800, "COMPLETED", date("13-09-2026")),
                new Employee(23, "divya", 9300, "IN_PROGRESS", date("15-09-2026")),
                new Employee(24, "sanjay", 12500, "COMPLETED", date("17-09-2026")),
                new Employee(25, "ravi", 8700, "PENDING", date("19-09-2026")),
                new Employee(26, "nisha", 11800, "COMPLETED", date("21-09-2026")),
                new Employee(27, "ajay", 9600, "IN_PROGRESS", date("23-09-2026")),
                new Employee(28, "swati", 11200, "COMPLETED", date("25-09-2026")),
                new Employee(29, "varun", 8100, "CANCELLED", date("27-09-2026")),
                new Employee(30, "tanya", 13000, "COMPLETED", date("30-09-2026"))
        );

        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysAgo= today.minusDays(29);


        List<Map.Entry<String,Integer>> topThreeCustomers = employees.stream()


                // filter based on status
                        .filter(e->e.status() == "COMPLETED")
                // filter based on last one month

                        .filter(employee -> !employee.createdAt().isBefore(thirtyDaysAgo) && !employee.createdAt().isAfter(today))
                //group the employee for extracting top one


                // Method references possible
                .collect(Collectors.groupingBy(
                        Employee::name,
                        Collectors.summingInt(Employee::amount)
                ))
                //now mapped with entry set
                        .entrySet()
                                .stream()
//                .map(Map.Entry.<String,Integer>)
                                        .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                                                .limit(3)
                                                        .toList();



        System.out.println("topThreeCustomers " + topThreeCustomers);
    }


}
