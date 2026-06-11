import java.util.*;
public class LinkedLists {

    public static void main(String[] args){
        // LinkedList as Deque (double-ended queue)
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addFirst(1);     // add to head
        deque.addLast(2);      // add to tail
        deque.removeFirst();   // remove from head
        deque.removeLast();    // remove from tail
        deque.peekFirst();     // head without removal
        deque.peekLast();      // tail without removal

// Manual LinkedList implementation (for interviews)
        class MyLinkedList {
            private static class Node {
                int val;
                Node next;
                Node(int val) { this.val = val; }
            }

            private Node head;
            private int size;

            public void addAtHead(int val) {
                Node node = new Node(val);
                node.next = head;
                head = node;
                size++;
            }

            public void addAtTail(int val) {
                if (head == null) { addAtHead(val); return; }
                Node curr = head;
                while (curr.next != null) curr = curr.next;
                curr.next = new Node(val);
                size++;
            }

            public int get(int index) {
                if (index < 0 || index >= size) return -1;
                Node curr = head;
                for (int i = 0; i < index; i++) curr = curr.next;
                return curr.val;
            }

            public void deleteAtIndex(int index) {
                if (index < 0 || index >= size) return;
                if (index == 0) { head = head.next; size--; return; }
                Node curr = head;
                for (int i = 0; i < index - 1; i++) curr = curr.next;
                curr.next = curr.next.next;
                size--;
            }
        }
    }

    // Trap 1: ConcurrentModificationException
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//for (int val : list) {
//        if (val % 2 == 0) list.remove(Integer.valueOf(val));  // THROWS CME!
//    }
// Fix: use Iterator.remove() or removeIf
//list.removeIf(val -> val % 2 == 0);  // Java 8+ cleanest way
//
//    // Trap 2: Arrays.asList returns fixed-size List
//    List<Integer> fixed = Arrays.asList(1, 2, 3);
//fixed.add(4);  // THROWS UnsupportedOperationException!
//    // Fix:
//    List<Integer> mutable = new ArrayList<>(Arrays.asList(1, 2, 3));
//
//    // Trap 3: remove(int) vs remove(Object)
//    List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
//list2.remove(1);                // removes INDEX 1 → list becomes [1, 3]
//list2.remove(Integer.valueOf(1)); // removes VALUE 1 → list becomes [2, 3]
//
//    // Trap 4: subList is a view
//    List<Integer> original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//    List<Integer> sub = original.subList(1, 4);  // [2, 3, 4]
//sub.set(0, 99);  // also modifies original! original = [1, 99, 3, 4, 5]
//    // To get independent copy:
//    List<Integer> copy = new ArrayList<>(original.subList(1, 4));
}

