import java.util.List;

public class mergeKListNode {
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
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.size()==0){
            return null;
        }
        return mergeHelper(lists,0,lists.size()-1);
    }
    public ListNode mergeHelper(List<ListNode> lists,int start,int end){
        if(start==end){
            return lists.get(start);
        }
        int mid=start+(end-start) /2;
        ListNode left=mergeHelper(lists,start,mid);
        ListNode right=mergeHelper(lists,mid+1,end);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                tail=l1;
                l1=l1.next;
            }
            else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            tail.next=l1;
        }
        else{
            tail.next=l2;
        }
        return dummy.next;
    }
}
