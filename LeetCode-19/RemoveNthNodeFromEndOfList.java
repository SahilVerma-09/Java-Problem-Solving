public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        // ListNode node6 = new ListNode(6);
        // ListNode node7 = new ListNode(7);
        // ListNode node8 = new ListNode(8);
        // ListNode node9 = new ListNode(9);
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // node5.next = node6;
        // node6.next = node7;
        // node7.next = node8;
        // node8.next = node9;

        ListNode dummy = node1;
        while(dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
        System.out.println();
        dummy = removeNthFromEnd(node1, 1);;
        
        
        
        while(dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
    }
    // [0,1,2,3,4,5,6,7]
    // [1,2,3,4,5,6,7,8], n = 2
    
    // 3
    // 7
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int length = 1;
        int slowPointerIndex = 1;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        boolean moveSlow = true;
        while(fastPointer != null) {
            if(fastPointer.next != null) {
                fastPointer = fastPointer.next;
                length++;
                moveSlow = !moveSlow;
            } else {
                break;
            }

            if(moveSlow) {
                slowPointer = slowPointer.next;
                slowPointerIndex++;
            }
        }

        if(length == 1 || length - n == 0) return head.next;

        int jumpIndex = length - n <= slowPointerIndex ? length - n : (length - n) - slowPointerIndex;

        if(length - n <= slowPointerIndex) {
            jumpIndex = length - n;
            for(int i = 1; i < length - n; i++) {
                dummy = dummy.next;
            }

            dummy.next = dummy.next.next;
        } else {
            for(int i = 1; i <= (length - n) - slowPointerIndex; i++) {
                slowPointer = slowPointer.next;
            }
            slowPointer.next = slowPointer.next.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
