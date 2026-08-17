public class MiddleNodeLinkedList {

    public static int middleNode(DetectCycleInALinkedList.ListNode node) {

        DetectCycleInALinkedList.ListNode slow = node;
        DetectCycleInALinkedList.ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }



    public static void main (String[] args) {
        DetectCycleInALinkedList.ListNode head = new DetectCycleInALinkedList.ListNode(1);

        head.next = new DetectCycleInALinkedList.ListNode(2);
        head.next.next = new DetectCycleInALinkedList.ListNode(5);
        head.next.next.next = new DetectCycleInALinkedList.ListNode(4);

        // Create cycle:
        // 4 → 2
//        head.next.next.next.next = head.next;



        System.out.println("Has cycle " + middleNode(head));

    }
}
