package com.jayanthi.linkedlists;

import com.jayanthi.linkedlists.FoldLinkedList.Node;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by m808421 on 2/18/17.
 */
public class RemoveDuplicates {

    public static Node removeDuplicates(Node head) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.value);
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (!set.add(current.value)) {
                current = current.next;
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }

        }
        return head;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.value+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}
