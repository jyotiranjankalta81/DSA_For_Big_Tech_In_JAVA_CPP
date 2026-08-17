public class MergeTwoSortedLinkedLists {

    // Node class
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node helps us easily build the result list
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        // Compare nodes from both lists
        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {

                current.next = list1;
                list1 = list1.next;

            } else {

                current.next = list2;
                list2 = list2.next;
            }

            // Move result pointer
            current = current.next;
        }

        // One list may still have remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // dummy itself is not part of result
        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // First sorted list
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(8);

        // Second sorted list
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(7);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        // Merge
        ListNode result = mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(result);
    }
}