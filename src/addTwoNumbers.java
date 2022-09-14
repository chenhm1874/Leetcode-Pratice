public class addTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null || l2==null){
            return null;
        }
        ListNode head=new ListNode(0);
        ListNode first=head;
        int carry=0;
        while(l1!=null&&l2!=null){
            int sum=carry+l1.val+l2.val;
            first.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            l2=l2.next;
            first=first.next;
        }
        while(l1!=null){
            int sum=carry+l1.val;
            first.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            first=first.next;
        }
        while(l2!=null){
            int sum=carry+l2.val;
            first.next=new ListNode(sum%10);
            carry=sum/10;
            l2=l2.next;
            first=first.next;
        }
        if(carry!=0){
            first.next=new ListNode(carry);
        }
        return head.next;
    }
}
