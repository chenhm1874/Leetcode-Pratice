import java.util.HashMap;

public class CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int val){
            this.value=val;
        }
    }
    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> hashmap=new HashMap<Node,Node>();
        Node cur=head;
        while (head!=null){
            hashmap.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            hashmap.get(cur).next=hashmap.get(cur.next);
            hashmap.get(cur).rand=hashmap.get(cur.rand);
            cur=cur.next;
        }
        return hashmap.get(head);
    }
    public static Node copyListWithRand2(Node head){
        if(head==null){
            return null;
        }
        Node cur=head;
        Node next=null;
        while(head!=null){
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=next;
            cur=next;
        }
        cur=head;
        Node curCopy=null;
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.rand.next:null;
        }
        Node res=head.next;
        cur=head;
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            cur.next=next;
            curCopy.next=next!=null? next.next:null;
            cur=next;
        }
        return res;
    }
}
