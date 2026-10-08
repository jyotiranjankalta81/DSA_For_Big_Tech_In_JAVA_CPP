package Problems;


import java.time.LocalDate;
import java.util.List;
import  java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*

Given orders with nested List<OrderItem>,
 find the top 5 most sold products by quantity, not by revenue.
 */
public class Problem7 {



  private   record OrderItem(
            int productId,
            String productName,
            int quantity,
            int price
    ) {}

  private  record Order(
            int orderId,
            int customerId,
            String status,
            LocalDate createdAt,
            List<OrderItem> items
    ) {}


    public  static void main (String[] args){
    List<Order> orders = List.of(
            new Order(
                    101,
                    1,
                    "COMPLETED",
                    LocalDate.of(2026, 9, 14),
                    List.of(
                            new OrderItem(1, "Laptop", 1, 60000),
                            new OrderItem(2, "Mouse", 2, 1000)
                    )
            ),
            new Order(
                    102,
                    2,
                    "COMPLETED",
                    LocalDate.of(2026, 9, 12),
                    List.of(
                            new OrderItem(3, "Keyboard", 1, 3000),
                            new OrderItem(4, "Monitor", 2, 15000)
                    )
            ),
            new Order(
                    103,
                    1,
                    "COMPLETED",
                    LocalDate.of(2026, 9, 10),
                    List.of(
                            new OrderItem(5, "Headphones", 2, 4000),
                            new OrderItem(6, "Webcam", 1, 5000)
                    )
            ),
            new Order(
                    104,
                    3,
                    "IN_PROGRESS",
                    LocalDate.of(2026, 9, 8),
                    List.of(
                            new OrderItem(7, "Tablet", 1, 30000),
                            new OrderItem(8, "Charger", 1, 2000)
                    )
            ),
            new Order(
                    105,
                    3,
                    "COMPLETED",
                    LocalDate.of(2026, 9, 5),
                    List.of(
                            new OrderItem(9, "Phone", 1, 45000),
                            new OrderItem(10, "PhoneCase", 2, 1000)
                    )
            ),
            new Order(
                    106,
                    4,
                    "COMPLETED",
                    LocalDate.of(2026, 8, 30),
                    List.of(
                            new OrderItem(11, "SmartWatch", 2, 12000),
                            new OrderItem(12, "WatchStrap", 3, 800)
                    )
            ),
            new Order(
                    107,
                    2,
                    "CANCELLED",
                    LocalDate.of(2026, 8, 27),
                    List.of(
                            new OrderItem(13, "Printer", 1, 18000),
                            new OrderItem(14, "InkCartridge", 2, 2500)
                    )
            ),
            new Order(
                    108,
                    5,
                    "COMPLETED",
                    LocalDate.of(2026, 8, 22),
                    List.of(
                            new OrderItem(15, "OfficeChair", 2, 10000),
                            new OrderItem(16, "Desk Lamp", 2, 2000)
                    )
            ),
            new Order(
                    109,
                    4,
                    "COMPLETED",
                    LocalDate.of(2026, 8, 18),
                    List.of(
                            new OrderItem(17, "SSD", 2, 7000),
                            new OrderItem(18, "RAM", 4, 3500)
                    )
            ),
            new Order(
                    110,
                    5,
                    "COMPLETED",
                    LocalDate.of(2026, 7, 20),
                    List.of(
                            new OrderItem(19, "Television", 1, 50000),
                            new OrderItem(20, "Soundbar", 1, 15000)
                    )
            )

    );




    /*
    List<Order>
→ filter eligible orders if required
→ flatten all OrderItem lists
→ group by productId
→ sum quantities
→ sort total quantities descending
→ take top 5
     */
    List<Map.Entry<String,Integer>> mostsolditems = orders.stream()
            .flatMap(e->e.items().stream())
            .collect(Collectors.groupingBy(OrderItem::productName,Collectors.summingInt(OrderItem::quantity)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
            .limit(5)
            .toList();


        List<Map.Entry<String,Integer>> higgestRevenueAcrossAllProducts = orders.stream()
                .flatMap(e->e.items().stream())
                .collect(Collectors.groupingBy(OrderItem::productName,Collectors.summingInt(OrderItem::price)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .limit(5)
                .toList();


//    System.out.println("mostsolditems   " + mostsolditems);
        System.out.println("higgestRevenueAcrossAllProducts   " + higgestRevenueAcrossAllProducts);

}
}
