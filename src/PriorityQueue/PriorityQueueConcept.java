package PriorityQueue;

//
//PriorityQueue = Binary Heap
//- Min-heap by default (smallest element at top)
//        - Backed by array
//- Parent-child relationship: parent at i, children at 2i+1 and 2i+2
//        - Heap property: parent <= children (min-heap)
//- Complete binary tree — no gaps in array

import java.util.*;
public class PriorityQueueConcept {


    public  static  void main (String[] args){
        // Min-heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// Or:
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((a, b) -> b - a);

// Custom comparator (e.g., sort by frequency)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);  // by second element

// Operations
        minHeap.offer(5);    // add
        minHeap.offer(1);
        minHeap.offer(3);
        System.out.println("min Heap***********************a"+minHeap);
        minHeap.peek();      // 1 (min, not removed)
        minHeap.poll();
        System.out.println("min Heap***********************b"+minHeap);// 1 (removes and returns min)
        minHeap.size();
        System.out.println("min Heap***********************c"+minHeap);
        minHeap.isEmpty();
        System.out.println("min Heap***********************d"+minHeap);

// Build from collection — O(n) (more efficient than n insertions)
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Arrays.asList(5, 3, 1, 4, 2));

// Convert to sorted array
        List<Integer> sorted = new ArrayList<>();
        while (!minHeap.isEmpty()) sorted.add(minHeap.poll());  // O(n log n);

        System.out.println("min Heap***********************"+minHeap);
    }
}
