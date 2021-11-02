import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class findElementInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(17);
        levelOrder(root);
        root = delete(root, 14);
        levelOrder(root);


    }

    private static Node delete(Node root, int key) {
        if (root == null)
            return null;
        else if (root.data == key) {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                int maxLeft = findMax(root.left);
                root.data = maxLeft;
                root.left = delete(root.left, maxLeft);
                return root;
            }
        } else if (key < root.data)
            root.left = delete(root.left, key);
        else
            root.right = delete(root.right, key);
        return root;
    }

    private static int findMax(Node root) {
        if (root == null)
            return -1;
        int max = root.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            max = Math.max(max, polled.data);
            if (polled.left != null)
                queue.add(polled.left);
            if (polled.right != null)
                queue.add(polled.right);
        }
        return max;
    }

    private static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void levelOrder(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node polled = q.poll();
            System.out.print(polled.data + " ");
            if (polled.left != null)
                q.add(polled.left);
            if (polled.right != null)
                q.add(polled.right);
        }
        System.out.println();
    }
}


