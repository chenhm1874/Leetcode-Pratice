import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class treeLevelOrderTraversal {
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
    //BFS
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List result=new ArrayList();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if(head.left!=null){
                    q.offer(head.left);
                }
                if(head.right!=null){
                    q.offer(head.right);
                }
            }
            result.add(level);

        }
        return result;
    }
    //DFS
    //public static List<List<Integer>> levelOrderTraversal1(TreeNode root){
}
