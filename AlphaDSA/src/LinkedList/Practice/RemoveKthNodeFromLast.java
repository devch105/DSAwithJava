package LinkedList.Practice;

import LinkedList.Linkedlist1;
import LinkedList.Linkedlist1.Node;

public class RemoveKthNodeFromLast {
   


    public static  Node removekthNodefromLast(Node head , int k){
    Node dummy = new Node(-1);
    dummy.next = head;
    Node currNode = dummy;
    Node prevNode = dummy;

    for(int i=0; i<k; i++){
        currNode = currNode.next;
        if(currNode == null){
            return head;
        }
    }
     while(currNode.next!=null){
            currNode = currNode.next;
            prevNode = prevNode.next;
        }
     
    prevNode.next = prevNode.next.next;
    return dummy.next;
    }

    public static void main(String[] args) {
        Linkedlist1 l = new Linkedlist1();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        Node headNode =  l.tempList(arr);
        l.PrintList(headNode);
        Node result = removekthNodefromLast(headNode,4);
        l.PrintList(result);
    }

}
