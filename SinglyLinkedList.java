import java.util.*;

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertAt(4, 5);
        list.print();
        System.out.print("head : ");
        list.printHead();

    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkList {
    private Node head = null;

    public void printHead() {
        if (head == null)
            System.out.println("null");
        else
            System.out.println(head.data);
    }

    public void insert(int num) {
        if (head == null)
            head = new Node(num);
        else {
            Node cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = new Node(num);
        }
    }

    public void insertAt(int num, int index) {
        Node node = new Node(num);
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }

        if (index > this.size() - 1) {
            insert(num);
            return;
        }
        Node cur = head;
        Node prev = null;
        int curInd = 0;
        while (curInd < index) {
            prev = cur;
            cur = cur.next;
            curInd++;
        }
        prev.next = node;
        node.next = cur;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public int size() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void delete(int ind) {
        if (ind < 0)
            return;
        if (ind <= this.size() - 1) {
            if (ind == 0) {
                Node temp = head.next;
                head.next = null;
                head = temp;
            } else {
                int curInd = 1;
                Node prev = head;
                while (curInd < ind) {
                    curInd++;
                    prev = prev.next;
                }
                prev.next = prev.next.next;
            }
        }
    }

    public void delete(Integer ele) {
        int e = ele;
        if (head.data == e) {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == e) {
                prev.next = prev.next.next;
                return;
            }
            prev = prev.next;
        }
    }


    public int get(int ind) {
        if (ind <= this.size() - 1 && ind >= 0) {
            if (ind == 0)
                return head.data;
            else {
                int curInd = 1;
                Node prev = head;
                while (curInd < ind) {
                    curInd++;
                    prev = prev.next;
                }
                return prev.next.data;
            }
        }
        return -1;
    }


}
