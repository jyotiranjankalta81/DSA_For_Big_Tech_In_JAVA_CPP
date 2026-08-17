public class DetectCycleInALinkedList {

    public static class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasCycle(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {

            // Slow moves 1 step
            slow = slow.next;

            // Fast moves 2 steps
            fast = fast.next.next;

            // Check immediately after movement
            if (slow == fast) {
                return true;
            }
        }

        return false;
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