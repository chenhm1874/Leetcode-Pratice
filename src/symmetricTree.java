public class symmetricTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return process(root.left,root.right);
    }
    public static boolean process(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot==null&& rightRoot==null){
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        if (leftRoot.val != rightRoot.val) {
            return false;
        }

        boolean left = process(leftRoot.left, rightRoot.right);
        boolean right = process(leftRoot.right, rightRoot.left);

        return left && right;
    }
}
