public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkList list = new DoublyLinkList();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(6);
        list.addAt(3,3);

        list.print();
        list.printAllNext();
        list.printAllPrev();
    }
}

class DoublyLinkList {
    private DoublyNode head = null;


    public void add(int ele) {
        DoublyNode node = new DoublyNode(ele);
        if (head == null) {
            head = node;
            return;
        }
        DoublyNode curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = node;
        node.prev = curr;

    }

    public void addFirst(int ele) {
        DoublyNode node = new DoublyNode(ele);
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void addAt(int i, int index) {
        if (index==0)
        {
            addFirst(i);
            return;
        }
        if (index>this.size()-1)
        {
            add(i);
            return;
        }
        DoublyNode node = new DoublyNode(i);
        DoublyNode cur = head;
        int curInd = 0;
        while (curInd < index) {
            cur = cur.next;
            curInd++;
        }
        node.next=cur;
        node.prev=cur.prev;
        cur.prev.next=node;
        cur.prev=node;


    }

    public void print() {
        DoublyNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printAllNext() {
        DoublyNode curr = head;
        while (curr != null) {
            if (curr.prev == null)
                System.out.print(-1 + " ");
            else
                System.out.print(curr.prev.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printAllPrev() {
        DoublyNode curr = head;
        while (curr != null) {
            if (curr.next == null)
                System.out.print(-1 + " ");
            else
                System.out.print(curr.next.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public int size() {
        int size = 0;
        DoublyNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
    }
}
