package Problems;
import java.util.*;
import java.util.stream.Collectors;

public class Problems11 {

    /*
    Given a transaction list:
    record Transaction(String userId, String type, double amount) {}
    find users whose total CREDIT > total DEBIT, and return:
    userId -> netBalance
    sorted by net balance descending.
    */

    private record Transaction(String userId, String type, double amount) {}

    public static void main(String[] args){



        List<Transaction> transactions = List.of(
                new Transaction("U101", "CREDIT", 5000.00),
                new Transaction("U101", "DEBIT", 800.00),
                new Transaction("U101", "CREDIT", 2000.00),
                new Transaction("U101", "DEBIT", 1000.00),
                new Transaction("U102", "DEBIT", 1200.00),
                new Transaction("U102", "CREDIT", 3000.00),
                new Transaction("U102", "DEBIT", 500.00),
                new Transaction("U103", "CREDIT", 7500.00),
                new Transaction("U103", "DEBIT", 1500.00),
                new Transaction("U103", "CREDIT", 2500.00),
                new Transaction("U104", "DEBIT", 2500.00),
                new Transaction("U104", "CREDIT", 4000.00),
                new Transaction("U105", "DEBIT", 1000.00),
                new Transaction("U105", "CREDIT", 6000.00),
                new Transaction("U105", "DEBIT", 2000.00)
        );

        List<Map.Entry<String,Double>> netbalancedescending = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::userId,
                        Collectors.collectingAndThen(Collectors.toList(),
                                transactionsList->{

                           double netCreditValue=transactionsList
                                   .stream()
                                   .filter(e->e.type=="CREDIT")
                                   .mapToDouble(Transaction::amount)
                                   .sum();
                           double netDebitValue=transactionsList
                                            .stream()
                                            .filter(e->e.type=="DEBIT")
                                            .mapToDouble(Transaction::amount)
                                            .sum();


                                    return netCreditValue > netDebitValue ? netCreditValue - netDebitValue : 0;


                        })
                        )).entrySet()
                .stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                .toList();

        System.out.println("netbalancedescending  " + netbalancedescending);



    }
}
