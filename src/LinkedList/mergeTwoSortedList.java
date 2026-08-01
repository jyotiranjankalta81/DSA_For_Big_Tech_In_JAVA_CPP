package LinkedList;

import java.util.*;

public class mergeTwoSortedList {


    public  static ListNode mergeTwoList(ListNode l1,ListNode l2){
        int counter =0;

        // Dummy node helps simplify insertion
        ListNode dummy = new ListNode(0);

        // Tail always points to the last node of the answer
        ListNode tail = dummy;
        while(l1!=null && l2!=null ){
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }


        }
        // Return actual head

        while(l1!=null){
            tail.next= new ListNode(l1.val);
            // Move tail
            tail = tail.next;
            l1 = l1.next;
        }
        while(l2!=null){
            tail.next= new ListNode(l2.val);
            // Move tail
            tail = tail.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // List 1 : 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // List 2 : 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoList(l1, l2);

        System.out.println("Below is the merged result:****");

        print(result);
    }
}
