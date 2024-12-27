package LinkedList.DoubleLinkedList;

public class MainOperations {
    public static void main(String[] args) {
        DLL dl=new DLL();

//        dl.insertionatbegining(2);
//        dl.traverse();
       dl.insertAtBeginning(1);
        dl.insertAtPosition(99,2 );
        dl.sortedInsertion(34);
        dl.sortedInsertion(214 );

        dl.sortedInsertion(114 );
        dl.sortedInsertion(64 );
        dl.traverse();
        System.out.println("size ->"+dl.getSize() );
       dl.deleteatPos(3);
        dl.traverse();

        System.out.println("size ->"+dl.getSize() );
    }
}
