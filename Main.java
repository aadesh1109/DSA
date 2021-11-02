import java.util.*;

public class Main {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node LCA = findLCA(root,root.left.left,root.right.left);
        if (LCA!=null)
            System.out.println(LCA.data);
        else
            System.out.println("doesnt exist");


    }

    private static Node findLCA(Node root , Node x , Node y) {
        if (root==null)
            return null;

        if (root.data==x.data || root.data==y.data)
            return root;

        Node leftRes = findLCA(root.left,x,y);
        Node rightRes = findLCA(root.right,x,y);

        if (leftRes==null) return rightRes;
        if (rightRes==null) return leftRes;
        return root;
    }

    private static void mirror(Node root) {
        if (root==null)
            return;

        mirror(root.left);
        mirror(root.right);
        Node curr = root.left;
        root.left=root.right;
        root.right = curr;
    }

    private static boolean isSymmetric(Node root) {
        return checkSymmetry(root.left,root.right);
    }

    private static boolean checkSymmetry(Node left, Node right) {
        if (left==null && right==null)
            return true;

        return left!=null && right!=null && left.data==right.data && checkSymmetry(left.left,right.right) && checkSymmetry(left.right,right.left);
    }

    private static int findDiameter(Node root) {

        if (root==null)
            return 0;
        return Math.max(findHeight(root.left)+findHeight(root.right)+1,Math.max(findDiameter(root.left),findDiameter(root.right)));
    }

    // Function to print all nodes of a given binary tree in specific
    // order from top to bottom
    public static void printNodes(Node root)
    {
        // return is tree is empty
        if (root == null) {
            return;
        }

        // print root node
        System.out.print(root.data + " ");

        // create a two empty queues and enqueue root's left and
        // right child respectively
        Queue<Node> first = new LinkedList<>();
        first.add(root.left);

        Queue<Node> second = new LinkedList<>();
        second.add(root.right);

        // loop till queue is empty
        while (!first.isEmpty())
        {
            // calculate number of nodes in current level
            int n = first.size();

            // process every node of current level
            while (n-- > 0)
            {
                // pop front node from first queue and print it
                Node x = first.poll();

                System.out.print(x.data + " ");

                // push left and right child of x to first queue
                if (x.left != null) {
                    first.add(x.left);
                }

                if (x.right != null) {
                    first.add(x.right);
                }

                // pop front node from second queue and print it
                Node y = second.poll();

                System.out.print(y.data + " ");

                // push right and left child of y to second queue
                if (y.right != null) {
                    second.add(y.right);
                }

                if (y.left != null) {
                    second.add(y.left);
                }
            }
        }
    }

    private static void inOrderTraversal(Node root) { //iteratively
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }

        }
    }

    private static boolean completeOrNot(Node root) {
        Queue<Node> queue = new LinkedList<>(); //always use linkedList class if working with nodes
        queue.add(root);
        boolean nullFound = false;
        while (!queue.isEmpty())
        {
            Node curr = queue.poll();
            if (curr==null)
                nullFound = true;
            else
            {
                if (nullFound)
                    return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }

        }
        return true;
    }

    public static Node findRightNode(Node root, int val)
    {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
                Node front = queue.poll();
                if (front.data == val)
                {

                    if (queue.peek()==null)
                        return null;
                    else
                        return queue.peek();
                }

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
        }
        return null;
    }

/*    private static void printzigzag(Node root)  { //using deque (can be done using flag method too)
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(Integer.MAX_VALUE));
        deque.addFirst(root);
        while (!(deque.peekFirst().data == Integer.MAX_VALUE) || !(deque.peekLast().data==Integer.MAX_VALUE))
        {
            while (deque.peekFirst().data!=Integer.MAX_VALUE)
            {
                Node curr = deque.pollFirst();
                System.out.print(curr.data+" ");
                if (curr.left!=null)
                    deque.addLast(curr.left);
                if (curr.right!=null)
                    deque.addLast(curr.right);
            }

            while (deque.peekLast().data!=Integer.MAX_VALUE)
            {
                Node curr = deque.pollLast();
                System.out.print(curr.data+" ");
                if (curr.right!=null)
                    deque.addFirst(curr.right);
                if (curr.left!=null)
                    deque.addFirst(curr.left);
            }
        }
    }*/

    private static void printZigZag(Node root) { //two stack method
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                Node curr = stack1.pop();
                System.out.print(curr.data+" ");
                if (curr.left!=null)
                    stack2.push(curr.left);
                if (curr.right!=null)
                    stack2.push(curr.right);

            }

            while (!stack2.isEmpty()){
                Node curr = stack2.pop();
                System.out.print(curr.data+" ");
                if (curr.right!=null)
                    stack1.push(curr.right);
                if (curr.left!=null)
                    stack1.push(curr.left);
            }
        }
    }

    private static void printLevelOrderRec(Node root) { //with rec without using extra space
        int i = 0;
        while (printLevelOrderRec(i,root)){
            i++;
        }
    }

    private static boolean printLevelOrderRec(int i,Node root) {
        if(root==null)
            return false;

        if (i==0)
        {
            System.out.print(root.data+" ");
            return true;
        }

        boolean left = printLevelOrderRec(i-1,root.left);
        boolean right = printLevelOrderRec(i-1,root.right);
        return left || right;
    }

/*    private static void printLevelOrderRec(Node root) { //with rec using extra space
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] range = {Integer.MIN_VALUE};
        printLevelOrderRec(0,root,map,range);
        for (int i = 0; i <=range[0] ; i++) {
            for ( int j : map.get(i)) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private static void printLevelOrderRec(int i, Node root, Map<Integer, ArrayList<Integer>> map, int[] range) {
        if (root==null)
            return;

        if (!map.containsKey(i))
        {
            map.put(i,new ArrayList<>());
        }
        map.get(i).add(root.data);
        printLevelOrderRec(i+1,root.left,map,range);
        printLevelOrderRec(i+1,root.right,map,range);
        range[0]=Math.max(range[0],i);
    }*/

    private static void printLevelOrder(Node root) {
        if (root==null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
    }

    private static int findHeight(Node x) {
        if (x==null)
            return 0;

        return 1+ Math.max(findHeight(x.left),findHeight(x.right));
    }

    private static boolean isIdentical(Node x, Node y) {
        if (x == null && y == null)
            return true;

        return (x != null && y != null) && (x.data == y.data) && isIdentical(x.left, y.left) && isIdentical(x.right, y.right);
    }
}

class Node {
    int data;
    Node left = null;
    Node right = null;

    public Node(int data) {
        this.data = data;
    }
}

