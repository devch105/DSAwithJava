package POTD.Jan.GFG;

public class Rotate_LinkedList {


    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public Node rotate(Node head, int k) {
        int len=1;
        Node tmp = head;
        while(tmp.next!=null){
            len++;
            tmp=tmp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        tmp.next = head;
        tmp=head;
        for(int i=1;i<k;i++){
            tmp=tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
        return head;
    }

}
