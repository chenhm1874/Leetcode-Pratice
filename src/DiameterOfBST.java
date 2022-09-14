public class DiameterOfBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public class ReturnType{
        int longest;
        int diagram;
        ReturnType(int longest,int diagram){
            this.diagram=diagram;
            this.longest=longest;
        }
    }
    public int DiameterOfBST(TreeNode root){
        if(root==null){
            return 0;
        }
        ReturnType result=helper(root);
        return result.diagram;
    }
    public ReturnType helper(TreeNode root){
        if(root==null){
            return new ReturnType(0,0);
        }
        ReturnType left=helper(root.left);
        ReturnType right=helper(root.right);
        int longest=Math.max(left.longest,right.longest)+1;
        int diagram=Math.max(left.diagram, right.diagram);
        diagram=Math.max(diagram,left.longest+right.longest);
        return new ReturnType(longest,diagram);
    }
}
