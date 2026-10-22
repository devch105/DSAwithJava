package LinkedList.Practice;

import LinkedList.Linkedlist1;
import LinkedList.Linkedlist1.Node;

public class LinkedListMidPoint {
    public static void main(String[] args) {
        Linkedlist1 li = new Linkedlist1();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node head =  li.tempList(arr);
        li.PrintList(head);

        System.out.println("Middle Node is : "+middlePoint(head).data);
    }

    public static  Node middlePoint(Node head){
        Node curr = head;
        Node prev = head;

        while( curr!=null && curr.next!=null){
            curr=curr.next.next;
            prev=prev.next;
        }
        return prev;
    }
}
