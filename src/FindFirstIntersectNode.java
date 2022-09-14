//先找到链表中是否有环在进行分类讨论。单链表找环的方法：hashset和快慢指针，快慢指针第一次相遇后慢指针停在原地快指针回到头节点，再同时走，每次只走一步。
//若两链表都无环，则判断条件：1）两链表结束位置物理地址相同，2）长的链表先开始遍历，走到跟短链表长度相同后
//若两链表都有环，则判断条件：1）两链表相交节点不在环上/在环上，不在环上时和无环情况相同，只不过终止节点变成了loop1和loop2；在环上不同点上相交和两有环链表不相交的区分方法，loop1在环上遍历的时候是否碰到loop2
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null || head2==null){
            return null;
        }
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        if (loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null && head.next == null && head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //cur1和cur2物理地址不同，一定没有相交，返回false
        if (cur1 != cur2) {
            return null;
        }
        //n表示两链表长度差值，cur1和cur2此时重定向，cur1指向较长链表，cur2指向较短链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1=null;
        Node cur2=null;
        if(loop1==loop2){
            cur1=head1;
            cur2=head2;
            int n=0;
            while(cur1!=loop1){
                n++;
                cur1=cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            while(cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            cur1=loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2){
                    return loop1;
                }
                cur1=cur1.next;
            }
            return null;
        }
    }
    public static void main(String[] args){
        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(4);
        head1.next.next.next.next=new Node(5);
        head1.next.next.next.next.next=new Node(6);
        head1.next.next.next.next.next.next=new Node(7);

        Node head2=new Node(0);
        head2.next=new Node(9);
        head2.next.next=new Node(8);
        head2.next.next.next=head1.next.next.next.next.next;    //8->6
        System.out.println(getIntersectNode(head1,head2).value);



    }
}
