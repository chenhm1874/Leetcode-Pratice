//满二叉树：层数为n的树一定有2^n-1个节点
public class isFullTree {
    public static class Info {
        public int height;
        public int nodes;

        public Info(int hi, int n) {
            this.height = hi;
            this.nodes = n;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFullTree(Node head) {
        if (head == null) {
            return true;
        }
        Info data = process(head);
        return data.nodes == (1 << data.height - 1);
    }

    public static Info process(Node x) {
        Info leftData = process(x.left);
        Info rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}
