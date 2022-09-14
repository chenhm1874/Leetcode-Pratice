//二叉树递归套路：从左右子树获得想要的信息，自己节点整合出这些信息，然后完成递归
public class BinaryTreeTaolu {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class returnType {
        public boolean isBalanced;
        public int height;

        public returnType(boolean isB, int hei) {
            this.isBalanced = isB;
            this.height = hei;
        }
    }

    public static returnType process(Node x) {
        if (x == null) {
            return new returnType(true, 0);
        }
        returnType leftData = process(x.left);
        returnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height)+1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new returnType(isBalanced, height);
    }

}
