import java.util.*;

public class zigzagLevelTraversal {
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
    public static List<List<Integer>> zzLevelTraversal(TreeNode root){
        List result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=true;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            for(int i=0;i< q.size();i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) {
                    q.offer(head.left);
                }
                if (head.right != null) {
                    q.offer(head.right);
                }
            }
            if(!flag){
                Collections.reverse(level);
            }
            result.add(level);
            flag=!flag;
        }
        return result;
    }
}
