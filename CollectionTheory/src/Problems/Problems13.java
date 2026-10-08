package Problems;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a list of logs:
record Log(String service, String level, String message) {}

find the most common ERROR message per service.
 */
public class Problems13 {
    private record Log(String service, String level, String message) {}


    public static void main(String[] args){
        List<Log> logs = List.of(
                new Log("Order-Service", "INFO", "Order created successfully"),
                new Log("Payment-Service", "ERROR", "Payment processing failed"),
                new Log("User-Service", "WARN", "Multiple failed login attempts"),
                new Log("Order-Service", "ERROR", "Unable to update order"),
                new Log("Inventory-Service", "INFO", "Stock updated successfully"),
                new Log("Payment-Service", "INFO", "Payment completed successfully"),
                new Log("User-Service", "ERROR", "User authentication failed"),
                new Log("Inventory-Service", "WARN", "Product stock is running low"),
                new Log("Order-Service", "INFO", "Order dispatched"),
                new Log("Notification-Service", "ERROR", "Email delivery failed"),
                new Log("Payment-Service", "WARN", "Payment gateway response is slow"),
                new Log("Notification-Service", "INFO", "SMS notification sent"),
                new Log("Inventory-Service", "ERROR", "Product is out of stock"),
                new Log("User-Service", "INFO", "User registered successfully"),
                new Log("Order-Service", "WARN", "Order processing is delayed")
        );

        Map<String, String> commonMessagePerService =
                logs.stream()
                        .filter(log -> "ERROR".equals(log.level()))
                        .collect(Collectors.groupingBy(
                                Log::service,
                                Collectors.collectingAndThen(
                                        Collectors.groupingBy(
                                                Log::message,
                                                Collectors.counting()
                                        ),
                                        messageCounts -> messageCounts.entrySet()
                                                .stream()
                                                .max(
                                                        Map.Entry
                                                                .<String, Long>comparingByValue()
                                                                .thenComparing(
                                                                        Map.Entry
                                                                                .<String, Long>comparingByKey()
                                                                                .reversed()
                                                                )
                                                )
                                                .map(Map.Entry::getKey)
                                                .orElse("")
                                )
                        ));



        System.out.println(commonMessagePerService);

    }


}
