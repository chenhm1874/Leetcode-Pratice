public class maxPathSum {
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
        int maxPath;
        int singlePath;
        returnType(int maxPath,int singlePath){
            this.singlePath=singlePath;
            this.maxPath=maxPath;
        }

    }
    private returnType helper(TreeNode root){
        if(root==null){
            return new returnType(Integer.MIN_VALUE,0);
        }
        returnType left=helper(root.left);
        returnType right=helper(root.right);
        int singlePath=Math.max(0,Math.max(left.singlePath, right.singlePath))+root.val;
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                Math.max(left.singlePath, 0) +
                        Math.max(right.singlePath, 0) + root.val);

        return new returnType(singlePath, maxPath);
    }
    public int maxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return helper(root).maxPath;
    }
}
