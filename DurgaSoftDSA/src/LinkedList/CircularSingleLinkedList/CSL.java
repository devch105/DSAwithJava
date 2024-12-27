package LinkedList.CircularSingleLinkedList;
public class CSL {
 Node tail;
 int size=0;

    class  Node{
        int val;
        Node next;

        Node(int data){
            this.val=data;
            this.next=null;
        }
    }
// print
    void Print(){
        if(size==0) {
            System.out.println("empty");
            return;
        }
        Node temp=tail.next;
        while (temp!=tail){
            System.out.println(temp.val+"->");
            temp=temp.next;
        }
        System.out.println(temp.val);
    }

 //
    public static void main(String[] args) {
        CSL l=new CSL();

    }

}
