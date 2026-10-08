package Problems;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given List<String> sentences, find the top 10 most frequent words,
 ignoring case and punctuation, sorted by frequency descending and alphabetically for ties.
 */
public class Problems10 {


    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is powerful, and Java is popular!",
                "Spring Boot makes Java development easier.",
                "Kafka is powerful for event-driven systems.",
                "Java and Spring Boot are widely used.",
                "Kafka, Spring, and Java are popular technologies.",
                "Docker and Kubernetes support modern systems.",
                "Spring Boot and Kafka work well together.",
                "Java developers use Docker and Kubernetes.",
                "Modern Java applications use Spring and Kafka.",
                "Java! Java? Spring; Kafka: Docker."
        );

/*
java=9 and=6 kafka=6 spring=6 docker=3 is=3 boot=3 kubernetes=2 modern=2 popular=2
sentences
→ normalize case and remove punctuation
→ flatMap into individual words
→ group by word
→ count occurrences
→ sort by frequency descending
→ sort alphabetically when frequencies tie
→ limit to 10
 */

        List<Map.Entry<String, Long>> topTenWords =
                sentences.stream()

                        // Stream<String sentence> → Stream<String word>
                        .flatMap(sentence ->
                                Arrays.stream(
                                        sentence.toLowerCase()
                                                .split("[^a-z0-9]+")
                                )
                        )
                        .filter(e -> !e.isBlank())
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .limit(10)
                        .toList();


        System.out.println("topTenWords   " + topTenWords);

    }


}
