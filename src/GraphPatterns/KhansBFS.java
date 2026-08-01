package GraphPatterns;


import java.util.*;

public class KhansBFS {

    public static void topologicalSort(
            List<List<Integer>> graph,
            int vertices) {

        /*
        ============================================
        STORE IN-DEGREE OF EVERY NODE
        ============================================
        */
        int[] indegree = new int[vertices];

        /*
        ============================================
        CALCULATE IN-DEGREE

        For every edge U -> V,
        increase indegree of V.
        ============================================
        */
        for (int u = 0; u < vertices; u++) {

            for (int v : graph.get(u)) {

                indegree[v]++;
            }
        }

        /*
        ============================================
        QUEUE STORES ALL NODES
        WITH IN-DEGREE = 0
        ============================================
        */
        Queue<Integer> queue =
                new LinkedList<>();

        for (int i = 0; i < vertices; i++) {

            if (indegree[i] == 0) {

                queue.offer(i);
            }
        }

        System.out.println("Topological Order:");

        /*
        ============================================
        BFS
        ============================================
        */
        while (!queue.isEmpty()) {

            // Remove current node
            int current = queue.poll();

            System.out.print(current + " ");

            /*
            ========================================
            REMOVE CURRENT NODE'S EDGES

            Reduce indegree of neighbors
            ========================================
            */
            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                /*
                If indegree becomes zero,

                it is ready to process.
                */
                if (indegree[neighbor] == 0) {

                    queue.offer(neighbor);
                }
            }
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
                5 → 2 → 3
                |       |
                v       v
                0       1
                ^
                |
                4 → 1
        */

        graph.get(5).add(2);
        graph.get(5).add(0);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        topologicalSort(graph, V);
    }
}