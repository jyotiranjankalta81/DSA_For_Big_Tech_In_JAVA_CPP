
public class DetectCycleStartNode {

    public static class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int hasCycle(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;
        // Phase 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return -1;
        }

        // Phase 2: Find cycle starting node
        slow = node;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);

        // Create cycle:
        // 4 → 2
        head.next.next.next.next = head.next;

        System.out.println("Has cycle " + hasCycle(head));
    }
}