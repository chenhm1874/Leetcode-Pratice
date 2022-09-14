public class LowestCommonAncestor {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
    public static Node lowestAncestor(Node head,Node o1,Node o2){
        if(head==null||head==o1||head==o2){
            return head;
        }
        Node left=lowestAncestor(head.left,o1,o2);
        Node right=lowestAncestor(head.right,o1,o2);
        //情况1：o1和o2的lowest ancestor是其中一个
        if(left!=null && right!=null){
            return head;
        }
        //情况二：o1,o2彼此互不为对方子树上的节点（换言之o1,o2的lowest ancestor不是他们其中一个）
        return left!=null?left:right;
    }
}
