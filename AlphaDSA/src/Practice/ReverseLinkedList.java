package Practice;

import LinkedList.Linkedlist1;

public class ReverseLinkedList {
    public static class Node {
        int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Linkedlist1.Node head;
    public static Linkedlist1.Node tail;
    public static int len = 0;



    public void reverseList(Node head){
        Node curr=head;
        Node prev=null,nxt=null;

        while (curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }

        head=prev;
    }

}
