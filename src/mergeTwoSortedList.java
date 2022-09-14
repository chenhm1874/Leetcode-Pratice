public class mergeTwoSortedList {
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
    public ListNode mergeTwoSortedList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode pointer=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pointer.next=l1;
                l1=l1.next;
            }else{
                pointer.next=l2;
                l2=l2.next;
            }
        }
        if(l1!=null){
            pointer.next=l1;
        }
        if(l2!=null){
            pointer.next=l2;
        }
        return dummy.next;
    }
}
