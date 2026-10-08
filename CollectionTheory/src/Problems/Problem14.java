package Problems;
import  java.util.*;

/*

Given:
record Employee(int id, String name, List<String> skills) {}

find the skill shared by the maximum number of distinct employees.
 */



public class Problem14 {

   private record Employee(
            int id,
            String name,
            List<String> skills
    ) {}


    public static void main(String[] args){

    List<Employee> employees = List.of(
            new Employee(
                    1,
                    "Robin",
                    List.of("Java", "Spring Boot", "Kafka")
            ),
            new Employee(
                    2,
                    "Ali",
                    List.of("Java", "AWS", "Docker")
            ),
            new Employee(
                    3,
                    "Paler",
                    List.of("Java", "Spring Boot", "SQL")
            ),
            new Employee(
                    4,
                    "Shane",
                    List.of("Python", "AWS", "Docker")
            ),
            new Employee(
                    5,
                    "Prem",
                    List.of("Java", "Kafka", "Kubernetes")
            ),
            new Employee(
                    6,
                    "Ruskin",
                    List.of("Spring Boot", "Java", "Docker")
            ),
            new Employee(
                    7,
                    "Neha",
                    List.of("Python", "SQL", "AWS")
            ),
            new Employee(
                    8,
                    "Rahul",
                    List.of("Java", "Java", "Spring Boot")
            )

    );
    //output Java=6


    }
}
