package GraphPatterns;


import java.util.*;

public class ShortestPathAlgo {

    public static void shortestPath(
            List<List<Integer>> graph,
            int source) {

        /*
        ============================================
        DISTANCE ARRAY

        -1 means

        Node not visited yet

        ============================================
        */
        int[] distance =
                new int[graph.size()];

        Arrays.fill(distance, -1);

        /*
        ============================================
        BFS QUEUE

        ============================================
        */
        Queue<Integer> queue =
                new LinkedList<>();

        /*
        ============================================
        SOURCE NODE

        Distance = 0

        ============================================
        */
        distance[source] = 0;

        queue.offer(source);

        /*
        ============================================
        BFS

        ============================================
        */
        while (!queue.isEmpty()) {

            // Current node
            int current = queue.poll();

            /*
            ========================================
            VISIT ALL NEIGHBORS

            ========================================
            */
            for (int neighbor : graph.get(current)) {

                /*
                ====================================
                NOT VISITED

                ====================================
                */
                if (distance[neighbor] == -1) {

                    /*
                    =================================
                    SHORTEST DISTANCE

                    Current + 1

                    =================================
                    */
                    distance[neighbor] =
                            distance[current] + 1;

                    queue.offer(neighbor);
                }
            }
        }

        /*
        ============================================
        PRINT DISTANCES

        ============================================
        */
        System.out.println("Shortest Distance:");

        for (int i = 0; i < distance.length; i++) {

            System.out.println(
                    "Node " + i +
                            " -> " +
                            distance[i]
            );
        }
    }

    public static void main(String[] args) {

        int V = 6;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {

            graph.add(new ArrayList<>());
        }

        /*
                  0
                /   \
               1     2
              / \     \
             3   4     5
        */

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(5);

        graph.get(3).add(1);

        graph.get(4).add(1);

        graph.get(5).add(2);

        shortestPath(graph, 0);
    }
}