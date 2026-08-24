public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode dummy = node1;
        while(dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
        System.out.println();
        dummy = deleteDuplicates(node1);;
        
        
        
        while(dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(-1);
        ListNode dummy = node;

        while(head.next != null) {
            if(head.val != head.next.val) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            head = head.next;
        }
        
        if(head != null && head.val != dummy.val) {
            dummy.next = new ListNode(head.val);
        }

        return node.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
