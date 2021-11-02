public class LowestCommonAncestor {
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
        Node lca = findLCA(root, 6, 17);
        System.out.println(lca.data);
    }

    private static Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node leftSearch = findLCA(root.left, n1, n2);
        Node rightSearch = findLCA(root.right, n1, n2);
        if (leftSearch != null && rightSearch != null)
            return root;
        if (leftSearch == null)
            return rightSearch;
        else
            return leftSearch;
    }

}
