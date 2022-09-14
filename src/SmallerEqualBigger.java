//给定一个单链表和一个pivot，返回一个单链表要求小于pivot的在左边等于pivot的在中间大于pivot的在右边
public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodearr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodearr.length; i++) {
            nodearr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodearr, pivot);
        for (i = 0; i < nodearr.length; i++) {
            nodearr[i - 1].next = nodearr[i];
        }
        nodearr[i - 1].next = null;
        return nodearr[0];
    }

    public static void arrPartition(Node[] nodearr, int pivot) {
        int small = -1;
        int big = nodearr.length;
        int index = 0;
        while (index != big) {
            if (nodearr[index].value < pivot) {
                swap(nodearr, ++small, index++);
            } else if (nodearr[index].value == pivot) {
                index++;
            } else {
                swap(nodearr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodearr, int a, int b) {
        Node tmp = nodearr[a];
        nodearr[a] = nodearr[b];
        nodearr[b] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;       //small head
        Node sT = null;       //small tail
        Node eH = null;       //equal head
        Node eT = null;       //equal tail
        Node mH = null;       //big head
        Node mT = null;       //big tail
        Node next = null;     //save next node
        //every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        //small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        //all connect
        if (eT != null) {
            eT = next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
}
