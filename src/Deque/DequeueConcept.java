package Deque;
import java.util.*;
public class DequeueConcept {
    public  static  void main (String[] args){
        Deque<Integer> deque = new ArrayDeque<>();

// Add to head / tail
        deque.addFirst(1);    // [1]
        deque.addLast(2);     // [1, 2]
        deque.offerFirst(0);  // [0, 1, 2]
        deque.offerLast(3);   // [0, 1, 2, 3]

// Remove from head / tail
        deque.removeFirst();  // 0 — [1, 2, 3]
        deque.removeLast();   // 3 — [1, 2]
        deque.pollFirst();    // 1 — [2]   (null if empty)
        deque.pollLast();     // 2 — []    (null if empty)

// Peek head / tail
        deque.peekFirst();    // null if empty
        deque.peekLast();     // null if empty
//        deque.getFirst();     // throws if empty
//        deque.getLast();      // throws if empty

// Stack usage (LIFO)
        deque.push(10);   // = addFirst
        deque.pop();       // = removeFirst
        deque.peek();      // = peekFirst

// Queue usage (FIFO)
        deque.offer(20);  // = addLast
        deque.poll();      // = removeFirst
        deque.peek();      // = peekFirst
        System.out.println("deque list items********************"+deque);
    }
}
