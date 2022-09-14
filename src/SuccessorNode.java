//中序遍历过程中的后继节点
//对于一个节点来说，存在以下几种情况：（1）存在右子树；其后继节点是它右子树上的最左节点
//                              （2）不存在右子树；后继节点是向上遍历过程中第一个作为父节点左孩子出现的父节点
public class SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getSuccessorNode(Node node){
        if(node==null){
            return node;
        }
        if(node.right!=null){
            return getLeftMost(node.right);
        }else{
            Node parent=node.parent;
            while(parent!=null && parent.left!=node){
                node=parent;
                parent=node.parent;
            }
            return parent;
        }
    }
    public static Node getLeftMost(Node node){
        if(node==null){
            return node;
        }
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }

}
