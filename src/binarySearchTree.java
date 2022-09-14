import java.util.Stack;

public class binarySearchTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
    //前中后序遍历的实质皆为每个节点遍历三遍，区别在于打印时机的不同（即第几遍遍历时执行打印）
    public static void inOrderRecursion(Node head){
        if(head==null){
            return;
        }
        inOrderRecursion(head.left);
        System.out.println(head.value);
        inOrderRecursion(head.right);
    }
    public static void preOrderRecursion(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        preOrderRecursion(head.left);
        preOrderRecursion(head.right);
    }
    public static void postOrderRecursion(Node head){
        if(head==null){
            return;
        }
        postOrderRecursion(head.left);
        postOrderRecursion(head.right);
        System.out.println(head.value);
    }
    public static void unRecurPreorder(Node head){
        System.out.println("pre-order");
        if(head!=null){
            Stack<Node> stack= new Stack<Node>();
            stack.push(head);
            while(!stack.isEmpty()){
                head=stack.pop();
                System.out.println(head.value);
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    public static void unRecurPostorder(Node head){
        System.out.println("post-order");
        if(head!=null){
            Stack<Node> s1=new Stack<Node>();
            Stack<Node> s2=new Stack<Node>();
            s1.push(head);
            while(!s1.isEmpty()){
                head=s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().value);
            }
        }
        System.out.println();
    }
    public static void unRecurInorder(Node head){
        System.out.println("in-order");
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            stack.push(head);
            while(!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    stack.pop();
                    System.out.println(head.value);
                    head=head.right;
                }
            }
        }
        System.out.println();
    }
    //宽度优先遍历用队列（LinkedList），弹出打印，依次放入左右子节点
    public static void main(String[] args){
        Node head=new Node(5);
        head.left=new Node(3);
        head.right=new Node(8);
        head.left.left=new Node(2);
        head.left.right=new Node(4);
        head.left.left.left=new Node(1);
        head.right.left=new Node(7);
        head.right.left.left=new Node(6);
        head.right.right=new Node(10);
        head.right.right.left=new Node(9);
        head.right.right.right=new Node(11);

        preOrderRecursion(head);
        inOrderRecursion(head);
        postOrderRecursion(head);

    }
}
