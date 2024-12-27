package LinkedList.SingleLinkedList;

public class problemOperationClass {
   // merge
    public static void mergeofTwoLinkedList(){
//        SLL l=new SLL();
//        l.AddLastNode(1);
//        l.AddLastNode(2);
//        l.AddLastNode(7);
//        l.printlist();
//        SLL lList2 = new SLL();
//        lList2.AddNodefirst(8);
//        lList2.AddNodefirst(4);
//        lList2.printlist();
//        SLL obj =new SLL();
//        obj.mergeofTwosortedList(l,lList2);
    }
    //  Intersection
    public  static  void  IntersectionofTwoLinkedList(){
//        SLL l=new SLL();
//        l.AddLastNode(1);
//        l.AddLastNode(2);
//        l.AddLastNode(5);
//
//        l.AddLastNode(7);
//        l.AddLastNode(8);
//        l.AddLastNode(9);
//
//        l.printlist();
//        SLL lList2 = new SLL();
//        lList2.AddNodefirst(8);
//        lList2.AddNodefirst(4);
//        lList2.AddLastNode(7);
//        lList2.AddLastNode(8);
//        lList2.AddLastNode(9);
//
//        lList2.printlist();
//        SLL obj =new SLL();
//        obj.IntersectionofTwoList(l,lList2);
    }

    //  Detect cycle
    public static void hascycle(){
        SLL l=new SLL();
        l.AddLastListNode(1);
        l.AddLastNode(2);
        l.AddLastNode(5);

        l.AddLastNode(7);
        l.AddLastNode(8);
        l.AddLastNode(9);

        System.out.println("Answer : "+l.HasaCycle(l.head));
    }

    // Palindrome LinkedList
    public static void palindrome(){
        SLL l=new SLL();
        l.AddLastListNode(2);
        l.AddLastListNode(1 );
        l.AddLastListNode(6);
        l.AddLastListNode(2);
        l.AddLastListNode(2);
        System.out.println("Answer : "+l.ispalindrome(l.head));

    }

    // Reversek Group
    public  static void reverseKGroup(){
        SLL l=new SLL();
        l.AddLastListNode(1);
        l.AddLastListNode(2 );
        l.AddLastListNode(3);
        l.AddLastListNode(4);
        l.AddLastListNode(5);
        int k=2;
        SLL l2=new SLL();

             l2.head  =l.reverseKGroup(l.head,k);
             l2.printlist();

    }


    public static void RemovefromLast(){
        SLL l=new SLL();
        l.AddLastListNode(1);
        l.AddLastListNode(2 );
        l.AddLastListNode(3);
        l.AddLastListNode(4);
        l.AddLastListNode(5);
        int k=3;
        SLL l2=new SLL();

        l2.head=
        l.Removenth(l.head,k);
        l2.printlist();
    }
      public static void main(String[] args) {
      //   mergeofTwoLinkedList();
         // IntersectionofTwoLinkedList();
         // hascycle();
          //palindrome();

          //reverseKGroup();
          RemovefromLast();



    }
}
