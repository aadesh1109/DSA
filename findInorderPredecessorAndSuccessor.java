public class findInorderPredecessorAndSuccessor {
    public static int predecessor=-1,successor=-1,state=0;
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
        inorderTraversal(root);
        findInorderPredAndSucc(root,6);
        System.out.println(predecessor+" "+successor);

    }

    private static void findInorderPredAndSucc(Node root, int key) {
        if (root==null)
            return;

        findInorderPredAndSucc(root.left,key);
        if (state==2)
            return;
        else if (state==0)
        {
            if (root.data==key)
                state++;
            else
                predecessor=root.data;
        }
        else if (state==1)
        {
            successor=root.data;
            state++;
        }
        findInorderPredAndSucc(root.right,key);
    }

    private static void inorderTraversal(Node root) {
        if (root==null)
            return;

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
}
