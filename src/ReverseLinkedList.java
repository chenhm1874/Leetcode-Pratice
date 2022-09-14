public class ReverseLinkedList {
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
    public ListNode ReverseLinkedList(ListNode head){
        if (head==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        head=dummy;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        return prev;
    }
}
