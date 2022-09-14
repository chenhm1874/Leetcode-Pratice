public class CompleteTreeNodeNumber {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
    public static int nodeNum(Node head){
        if(head==null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }
    public static int mostLeftLevel(Node node,int level){       //求该子树的深度
        while(node!=null){
            node=node.left;
            level++;
        }
        return level-1;
    }
    public static int bs(Node node,int level,int h){        //求当前节点的子节点个树，level表示当前节点所处层
        if(level==h){
            return 1;
        }
        if (mostLeftLevel(node.right,level+1)==h){
            return (1<<(h-level))+bs(node.right,level+1,h);
        }else{
            return (1<<(h-level-1))+bs(node.left,level+1,h);
        }
    }
}
