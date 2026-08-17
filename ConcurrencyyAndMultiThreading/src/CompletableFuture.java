//public class CompletableFuture {
//}
//import java.util.concurrent.CompletableFuture;
//
//public class DashboardService {
//
//    public Dashboard getDashboard() {
//
//        CompletableFuture<User> userFuture =
//                CompletableFuture.supplyAsync(
//                        () -> userService.getUser());
//
//        CompletableFuture<Order> orderFuture =
//                CompletableFuture.supplyAsync(
//                        () -> orderService.getOrder());
//
//        CompletableFuture<Payment> paymentFuture =
//                CompletableFuture.supplyAsync(
//                        () -> paymentService.getPayment());
//
//        CompletableFuture.allOf(
//                        userFuture,
//                        orderFuture,
//                        paymentFuture)
//                .join();
//
//        return new Dashboard(
//                userFuture.join(),
//                orderFuture.join(),
//                paymentFuture.join());
//    }
//}