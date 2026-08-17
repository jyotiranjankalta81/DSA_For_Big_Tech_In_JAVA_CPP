
public class ReverseLinkedList {

    // Node class
   public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse linked list
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            // 1. Save the next node
            ListNode next = current.next;

            // 2. Reverse the link
            current.next = prev;

            // 3. Move prev forward
            prev = current;

            // 4. Move current forward
            current = next;
        }

        // prev is the new head
        return prev;
    }

    // Print linked list
    public static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original:");
        printList(head);

        // Reverse
        head = reverseList(head);

        System.out.println("Reversed:");
        printList(head);
    }
}