public class BinarySearchTree {
    Node root;
    private int max = Integer.MIN_VALUE;

    public void insert(int data) {
        if (root==null)
        {
            root = new Node(data);
            return;
        }

        insert(root,data);

    }

    private Node insert(Node curr,int data){

        if (curr==null)
        {
            return new Node(data);
        }


        if (data<curr.data)
            curr.left=insert(curr.left,data);
        else
            curr.right=insert(curr.right,data);

        return curr;

    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node curr) {

        if (curr==null)
            return;

        System.out.println(curr.data);
        preOrderTraversal(curr.left);
        preOrderTraversal(curr.right);

    }

    public boolean searchKey(int i) {

        return searchKey(root,i);


    }

    public boolean searchKey(Node curr ,int data) {

        if (curr==null)
            return false;

        if (curr.data==data)
            return true;

        if (data<curr.data)
            return searchKey(curr.left,data);
        else
            return searchKey(curr.right,data);



    }

    public void delete(int data) {
        root = delete(root,data);
    }

    private Node delete(Node curr ,int data) {

        if (curr==null)
            return null;

        if (curr.data==data) {

            if (curr.left == null && curr.right == null)
                return null;

            if (curr.right == null)
                return curr.left;

            if (curr.left == null)
                return curr.right;

            int maximum = findMax(curr.left);
            curr.data=maximum;
            curr.left=delete(curr.left,maximum);

        }

        if (data<curr.data)
            curr.left=delete(curr.left,data);
        else
            curr.right=delete(curr.right,data);

        return curr;

    }

    public int findMax(Node curr) {

        findMaxHelper(curr);
        int x = max;
        max=Integer.MIN_VALUE;
        return x;


    }

    private void findMaxHelper(Node curr) {

        if (curr==null)
            return;

        max=Integer.max(max,curr.data);
        findMaxHelper(curr.left);
        findMaxHelper(curr.right);

    }


    public int findHeight() {
        return findHeight(root)-1;
    }

    private int findHeight(Node curr){

        if (curr==null)
            return 0;

        return 1+Integer.max(findHeight(curr.left),findHeight(curr.right));

    }

    public boolean isBalanced() {
        HeightAndISBalanced x = isBalanced(root);
        return x.isBalanced;
    }

    private HeightAndISBalanced isBalanced(Node curr)
    {
        if (curr==null)
            return new HeightAndISBalanced(0,true);

        HeightAndISBalanced left =isBalanced(curr.left);

        if (!left.isBalanced)
            return new HeightAndISBalanced(left.height, false);

        HeightAndISBalanced right =  isBalanced(curr.right);

        if (left.isBalanced && right.isBalanced && Math.abs(left.height- right.height)<=1)
            return new HeightAndISBalanced(1+Integer.max(left.height, right.height),true);
        else
            return new HeightAndISBalanced(1+Integer.max(left.height, right.height),false);
    }

    public void createBalancedBinarySearchTree(int[] arr) {

        root = createBalancedBinarySearchTree(null,arr,0,arr.length-1);

    }


    private Node createBalancedBinarySearchTree(Node curr,int[] arr,int l,int r) {

        if (l>r)
            return null;

            int mid = l+(r-l)/2;
            curr = new Node(arr[mid]);
            curr.left = createBalancedBinarySearchTree(curr.left,arr,l,mid-1);
            curr.right = createBalancedBinarySearchTree(curr.right,arr,mid+1,r);
            return curr;

    }



}
class HeightAndISBalanced{
    int height;
    boolean isBalanced;

    public HeightAndISBalanced(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
