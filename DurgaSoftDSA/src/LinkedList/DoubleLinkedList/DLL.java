package LinkedList.DoubleLinkedList;

public class DLL {
    Node head;
    int size;

    // Node Class
    class Node {
        Node prev;
        int val;
        Node next;

        Node(int data, Node prev, Node next) {
            this.val = data;
            this.prev = prev;
            this.next = next;
        }
    }

    int getSize() {
        return size;
    }

    // Print list
    void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    // AddFirst DLL
    void insertAtBeginning(int data) {
        Node newNode = new Node(data, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    // Add at Last
    void insertAtLast(int data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
        }
        size++;
    }

    // Add at position
    void insertAtPosition(int data, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Out of range");
            return;
        }

        if (pos == 0) {
            insertAtBeginning(data);
            return;
        }

        if (pos == size) {
            insertAtLast(data);
            return;
        }

        Node currNode = head;
        for (int i = 0; i < pos - 1; i++) {
            currNode = currNode.next;
        }

        Node newNode = new Node(data, currNode, currNode.next);
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        }
        currNode.next = newNode;
        size++;
    }

    // Sorted Insertion
    void sortedInsertion(int data) {
        Node newNode = new Node(data, null, null);
        if (head == null || head.val >= data) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null && currNode.next.val < data) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            if (currNode.next != null) {
                currNode.next.prev = newNode;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
        }
        size++;
    }

// delete first
    void deletefirst(){
        if(head==null){
            System.out.println("empty");
        }
        size--;
        head=head.next;
        if(head!=null)
            head.prev=null;
    }

    //delete last
    void deletelast(){
        if (head==null){
            System.out.println("empty");
        }if(head.next==null){
            head=null;
            size--;
            return;
        }
        size--;
        Node temp1=head,temp2=head.next;
        while (temp2.next!=null){
            temp2=temp2.next;
            temp1=temp1.next;
        }
        temp1.next=null;
    }

    // delete at pos

    void deleteatPos(int pos){
        int i=0;
        Node temp1=head,temp2=head.next;
        if(size==0){
            System.out.println("empty");
        }
        if(pos<0 || pos>=size){
            System.out.println("out of Range");
        }
        if(pos==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
            size--;
            return;
        }
        while (temp1.next!=null &&  i<pos){
            if(i==pos-1){
                  temp1.next=temp1.next.next;
                  temp2=temp1.next;
                  if(temp2!=null)
                      temp2.prev=temp1;
                  size--;
            }
            i++;
            temp1=temp1.next;

        }

    }

    // Delete by value
    void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null && currNode.val != data) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("Value not found in the list");
            return;
        }

        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        } else {
            head = currNode.next;
        }

        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        }

        size--;
    }

    // Function to reverse the doubly linked list
    public void reverse() {
        Node temp = null;
        Node currNode = head;

        // Traverse the list and swap next and prev for each node
        while (currNode != null) {
            temp = currNode.prev; // Store the current prev
            currNode.prev = currNode.next; // Swap prev and next
            currNode.next = temp; // Assign stored prev to next
            currNode = currNode.prev; // Move to the next node in original order
        }

        // Update the head of the list if the list is not empty
        if (temp != null) {
            head = temp.prev; // `temp` will point to the new head's previous node
        }
    }











    // Test the DLL class
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtBeginning(10);
        dll.insertAtLast(20);
        dll.insertAtPosition(15, 1);
        dll.traverse();
        dll.sortedInsertion(12);
        dll.traverse();
        dll.deleteByValue(15);
        dll.traverse();
        dll.reverse();
        dll.traverse();
    }
}
