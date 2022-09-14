public class reverseKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
        return head;
    }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
        // get the tail node in a k-group
        int count = 1;
        ListNode tail = curr;
        while (tail != null && count < k) {
            tail = tail.next;
            count++;
        }
        // if the rest nodes length is less than k
        // then remains the same
        if (tail == null) {
            break;
        }

        // do the k-group reverse
        //     prev   (before reversed)     next
        //      |             |              |
        // 2 -> 1   ->    (3  ->  4)    ->   5
        //                 |      |
        //                curr   tail
        ListNode next = tail.next;
        reverse(curr, k);

        //     prev   (after reversed)     next
        //      |             |              |
        // 2 -> 1   ->    (4  ->  3)    ->   5
        //                 |      |
        //                tail   curr
        prev.next = tail;
        curr.next = next;

        //             (after reversed)
        //                    |
        // 2 -> 1   ->    (4  ->  3)    ->   5
        //                        |          |
        //                       prev       curr
        prev = curr;
        curr = next;
    }
        return dummy.next;
}

    private void reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
