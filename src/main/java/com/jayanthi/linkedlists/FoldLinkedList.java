package com.jayanthi.linkedlists;

public class FoldLinkedList {

    public static void foldLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        Node middle = slow;
        Node second = reverseLinkedList(slow);
        Node first = head;
        while (fast != null && middle != head) {
            Node tempFirst = first.next;
            Node tempSec = second.next;
            second.next = first.next;
            first.next = second;
            first = tempFirst;
            second = tempSec;
        }

        if (second != null) {
            second.next = null;
        } else {
            first.next = null;
        }
    }

    public static Node reverseLinkedList(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args)
    {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        a.printLinkedList();
        foldLinkedList(a);
        a.printLinkedList();

    }

    static class Node
    {
        public Node next;
        public int value;

        public Node(int value)
        {
            this.value = value;
        }

        public void printLinkedList()
        {
            Node head = this;
            while (head != null)
            {
                System.out.print(head.value + "->");
                head = head.next;
            }
            System.out.println();
        }

    }
}
