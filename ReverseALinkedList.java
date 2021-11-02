public class ReverseALinkedList {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = head.next;
        removeLoopIfPresent(head);
        print(head);

    }

    private static void removeLoopIfPresent(Node head) {
        if (head==null || head.next==null)
            return;

        Node slow = head;
        Node fast=head;
        Node prevFast=null;
        do {
            slow=slow.next;
            prevFast=fast.next;
            fast=fast.next.next;
            if (slow==fast)
            {
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    prevFast=fast;
                    fast=fast.next;
                }
                prevFast.next=null;
                return;
            }
        }while (slow!=null && fast!=null && fast.next!=null);
    }

    private static boolean detectLoop(Node head) {
        if(head==null || head.next==null)
            return false;
        Node slow=head;
        Node fast=head;
        do{
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }while(slow!=null && fast!=null && fast.next!=null);
        return false;
    }

    private static Node reverseInGroupsOfK(Node head, int k) {
        if (head == null)
            return null;
        int K = k;
        Node curr = head;
        Node prev = null;
        while (curr != null && K > 0) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            K--;
        }
        Node PrevSubNodeTail = head;
        head = prev;
        if (K > 0)
            return head;
        K = k;
        Node grpStart = curr;
        prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            K--;
            if (K == 0) {
                PrevSubNodeTail.next = prev;
                PrevSubNodeTail = grpStart;
                grpStart = curr;
                prev = null;
                K = k;
            }
        }
        if (K > 0) {
            PrevSubNodeTail.next = prev;
        }
        return head;
    }

    private static Node reverseIteratively(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node reverseInRange(Node head, int left, int right) {
        Node curr = head;
        if (left == 1) {
            Node prev = null;
            while (left <= right) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                left++;
            }
            head.next = curr;
            head = prev;
        } else {
            int count = 1;
            Node lPrev = null;
            while (count < left) {
                lPrev = curr;
                curr = curr.next;
                count++;
            }
            Node prev = null;
            while (left <= right) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                left++;
            }
            lPrev.next.next = curr;
            lPrev.next = prev;

        }
        return head;

    }

    private static void print(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node reverse(Node head) { //recursive
        return reverse(head, null);
    }

    private static Node reverse(Node curr, Node prev) { //recursive
        if (curr == null)
            return prev;
        Node head = reverse(curr.next, curr);
        curr.next = prev;
        return head;
    }
}
