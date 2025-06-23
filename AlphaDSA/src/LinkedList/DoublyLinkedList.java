package LinkedList;

public class DoublyLinkedList {
    public static DNode head;
    public static DNode tail;
    public static int size;

    class DNode{
        int data;
        DNode prev;
        DNode next;

        public DNode(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
// ** ADD First
    public void Add_First_DLL(int data){
        DNode newnode = new DNode(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;

    }

// ** PrintList
    public  void  printlist(){
        DNode temp=head;
        System.out.print("head : ");
        while (temp!=null){
            System.out.print("->"+temp.data);
            temp=temp.next;
        }
        System.out.println("->null");
    }

// ** RemoveFirst
    public int RemoveFirst_DLL(){
        if(head==null){
            System.out.println("Empty");
            return -1;
        }
        int val=head.data;
        head=head.next;
        return val;
    }



    public static void main(String[] args) {
        DoublyLinkedList l1=new DoublyLinkedList();
        l1.Add_First_DLL(2);
        l1.Add_First_DLL(5);
        l1.Add_First_DLL(21);
        l1.printlist();
        System.out.println("value :" +l1.RemoveFirst_DLL());
        l1.printlist();
    }

}
