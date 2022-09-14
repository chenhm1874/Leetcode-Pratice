package Tree;

import java.util.Stack;

public class BSTPreorderTraversal {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.value=val;
        }
    }
    public static void preOrderRecur(TreeNode head){
        if(head==null){
            return;
        }
        System.out.println(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void preOrderStack(TreeNode head){
        Stack<TreeNode> stack= new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode head1=stack.pop();
            System.out.println(head1.value+" ");
            if(head1.left!=null){
                stack.add(head1.left);
            }
            if (head1.right!=null){
                stack.add(head1.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(5);
        head.left=new TreeNode(3);
        head.right=new TreeNode(8);
        head.left.left=new TreeNode(2);
        head.left.right=new TreeNode(4);
        head.left.left.left=new TreeNode(1);
        head.right.left=new TreeNode(7);
        head.right.right=new TreeNode(10);
        head.right.right.left=new TreeNode(9);
        head.right.right.right=new TreeNode(11);
        System.out.println("pre-order:");
        preOrderRecur(head);
        System.out.println();
    }
}
