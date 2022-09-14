public class ValidateBST {
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
    public class returnType{
        boolean isBST;
        TreeNode maxNode;
        TreeNode minNode;
        returnType(boolean isBST){
            this.isBST=isBST;
            maxNode=minNode=null;
        }
    }
    public boolean checkBST(TreeNode root){
        return process(root).isBST;
    }
    public returnType process(TreeNode root){
        returnType left=process(root.left);
        returnType right=process(root.right);
        if(!left.isBST && !right.isBST){
            return new returnType(false);
        }
        if(left.maxNode.val>root.val && left.maxNode!=null){
            return new returnType(false);
        }
        if(right.minNode!=null && right.minNode.val<root.val){
            return new returnType(false);
        }
        returnType result= new returnType(true);
        result.minNode=left.minNode!=null? left.minNode:root;
        result.maxNode=right.maxNode!=null?right.maxNode:root;
        return result;
    }
}
