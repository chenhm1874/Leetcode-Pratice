import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//是否为BST：所有节点都满足左子树小于父节点，右子树大于父节点
//是否为完全二叉树：除了最底层每一层都放满，最后一层不放满也是从左到右依次填满一棵树，每个节点遍历若有右无左则直接false
//若满足第一个条件则当遍历到第一个左右子节点不全的节点后，后面所有的节点都为叶节点
//是否为满二叉树（宽度优先遍历）：
public class BSTQuestions {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
    public static int preValue=Integer.MIN_VALUE;
    public static boolean isBST1(Node head){
        if(head==null){
            return true;
        }

        boolean isLeftBST=isBST1(head.left);
        if(!isLeftBST){
            return false;
        }
        if(head.value<preValue){
            return false;
        }else{
            preValue= head.value;
        }
        return isBST1(head.right);
    }
    public static boolean isBST2(Node head){
        if (head!=null){
            preValue=Integer.MIN_VALUE;
            Stack<Node> stack=new Stack<Node>();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head=stack.pop();
                    if(head.value<=preValue){
                        return false;
                    }else{
                        preValue= head.value;;
                    }
                    head=head.right;
                }
            }
        }
        return true;
    }
    public static boolean isCBT1(Node head){
        if(head==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<Node>();
        boolean leaf=false;
        Node l=null;
        Node r=null;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if((leaf&& (l!=null ||r!=null))     //碰到叶节点的时候左右节点有一个不为空
                    ||
                    (l==null && r!=null)    //碰到有右孩子无左孩子的节点
            ){
                return false;
            }
            if(l!=null){
                queue.add(l);
            }
            if(r!=null){
                queue.add(r);
            }
            if(l==null ||r ==null){
                leaf=true;
            }
        }
        return true;
    }
}
