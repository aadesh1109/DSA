import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(8);
        root.left.left = new Node(12);
        root.right.right = new Node(9);
        createMirror(root);
        for (Integer i : inOrder(root)) {
            System.out.print(i+" ");
        }
    }

    private static ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private static void inOrder(Node root, ArrayList<Integer> list)
    {
        if (root==null)
            return;
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }



    private static void createMirror(Node root) {
        if(root==null || (root.left==null && root.right==null))
            return;

        Node temp = root.left;
        root.left=root.right;
        root.right=temp;

        createMirror(root.left);
        createMirror(root.right);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return false;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return root1.data == root2.data && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);

    }


    public static int diameter(Node root) {
        if (root == null)
            return 0;
        return Math.max(1 + height(root.left) + height(root.right), Math.max(diameter(root.left), diameter(root.right)));
    }

    public static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        while (!q.isEmpty()) {
            Node polled = q.poll();
            list.add(polled.data);
            if (polled.left != null)
                q.add(polled.left);
            if (polled.right != null)
                q.add(polled.right);
        }
        return list;
    }

    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            Node polled = q.poll();
            stack.add(polled.data);
            if (polled.right != null)
                q.add(polled.right);
            if (polled.left != null)
                q.add(polled.left);
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
