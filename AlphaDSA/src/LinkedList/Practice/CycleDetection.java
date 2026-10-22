package LinkedList.Practice;

import LinkedList.Linkedlist1;
import LinkedList.Linkedlist1.Node;

public class CycleDetection {
    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.next = new Node(2);
        newNode.next.next = new Node(3);
        newNode.next.next.next = new Node(4);
        newNode.next.next.next.next = new Node(5);
        newNode.next.next.next.next.next = new Node(6);
        newNode.next.next.next.next.next.next = new Node(7);
        
        Node heaNode = newNode;

        Linkedlist1 li = new Linkedlist1();

        li.PrintList(heaNode);
        
        newNode.next.next.next.next.next.next.next = heaNode.next.next.next;

        System.out.println("LinkedList has cyle : "+hasCycle(heaNode));

    }

    public static boolean hasCycle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast!=null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
