package LinkedList.Practice;

import LinkedList.Linkedlist1;
import LinkedList.Linkedlist1.Node;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        Linkedlist1 l = new Linkedlist1();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        Node headA =  l.tempList(arr);
        l.PrintList(headA);
        
        Node newNode = new Node(100);
        Node currNode = newNode;
        for(int i=101; i<105; i++){
            currNode.next = new Node(i);
            currNode=currNode.next;
        }
        currNode.next = headA.next.next.next.next;
        Node headB = newNode;
        l.PrintList(headB);
        Node result = interSectionOfLinkedList(headA, headB);
        System.out.println("Result : "+result.data);
    }


    public static  Node interSectionOfLinkedList(Node headA, Node headB){
        Node ptr_A =headA;
        Node ptr_B =headB;

        while(ptr_A!=ptr_B){
           ptr_A = ptr_A!=null ? ptr_A.next : headB;
           ptr_B = ptr_B!=null ? ptr_B.next : headA;
        }
        return  ptr_A;
    }
}
