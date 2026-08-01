package GraphPatterns;

import java.util.*;
/*
============================================
EDGE CLASS

Stores

Neighbor

+

Weight

============================================
*/
class Edge {

    int node;
    int weight;

    Edge(int node, int weight) {

        this.node = node;
        this.weight = weight;
    }
}
public class DijkstraAlgorithm {

    public static  void dijkstraAlgo(List<List<Edge>> graph,
                                     int source){
        int[] distance = new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);

        /*
        ============================================
        SOURCE

        Distance = 0

        ============================================
        */
        distance[source]=0;

        /*
        ============================================
        PRIORITY QUEUE

        Stores

        (Node, Distance)

        Smallest distance first

        ============================================
        */

        PriorityQueue<Edge> pq =
                new PriorityQueue<>(
                        (a, b) -> a.weight - b.weight
                );

        pq.offer(new Edge(source, 0));

        /*
        ============================================
        DIJKSTRA

        ============================================
        */


        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int currentNode = current.node;
            int currentDistance = current.weight;

            /*
            ========================================
            IGNORE OLD ENTRIES

            ========================================
            */

            if (currentDistance > distance[currentNode]) {
                continue;
            }
            /*
            ========================================
            VISIT ALL NEIGHBORS

            ========================================
            */

            for (Edge neighbor : graph.get(currentNode)) {
                int newDistance =
                        currentDistance +
                                neighbor.weight;

                /*
                ====================================
                FOUND SHORTER PATH

                Update

                ====================================
                */
                if (newDistance < distance[neighbor.node]) {

                    distance[neighbor.node] = newDistance;

                    pq.offer(
                            new Edge(
                                    neighbor.node,
                                    newDistance
                            )
                    );
                }


            }
        }

         /*
        ============================================
        PRINT SHORTEST DISTANCES

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
    public static  void main(String [] args){
        int V = 4;

        List<List<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {

            graph.add(new ArrayList<>());
        }

        /*
                  4
            0 -------- 1
            |          |
          1 |          | 2
            |          |
            2 -------- 3
                5
        */

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));

        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(3, 2));

        graph.get(2).add(new Edge(0, 1));
        graph.get(2).add(new Edge(3, 5));

        graph.get(3).add(new Edge(1, 2));
        graph.get(3).add(new Edge(2, 5));

        dijkstraAlgo(graph, 0);


    }
}
