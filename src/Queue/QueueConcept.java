package Queue;
import java.util.*;
public class QueueConcept {

    public static void main (String[] args){

        // FIFO: add to tail, remove from head
        Queue<Integer> queue = new ArrayDeque<>();

// Enqueue (add to tail)
        queue.offer(1);   // preferred (returns false on failure)
        queue.add(2);     // throws exception on failure
        queue.offer(3);

// Dequeue (remove from head)
        int front = queue.poll();    // removes and returns head (null if empty)
        int front2 = queue.remove(); // removes and returns head (throws if empty)

// Peek head
        int peek = queue.peek();   // null if empty
        int peek2 = queue.element(); // throws if empty

// Check
        queue.isEmpty();
        queue.size();
    }


}


/*
// BFS template — used for trees, graphs, shortest path
public int bfs(int[][] grid, int startR, int startC) {
    int rows = grid.length, cols = grid[0].length;
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[rows][cols];

    queue.offer(new int[]{startR, startC});
    visited[startR][startC] = true;
    int distance = 0;

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    while (!queue.isEmpty()) {
        int size = queue.size();  // process level by level
        for (int i = 0; i < size; i++) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (isTarget(grid, r, c)) return distance;

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc] && grid[nr][nc] != 0) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        distance++;
    }
    return -1;  // not found
}
 */