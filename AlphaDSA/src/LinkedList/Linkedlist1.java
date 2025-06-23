package LinkedList;

import LinkedList.Practice.PartitionList;
import Practice.ReverseLinkedList;

public class Linkedlist1 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int len = 0;

    /* Add First */
    public void AddFirst(int data) {
        Node newnode = new Node(data);
        len++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    /* Add Last */
    public void AddLast(int data) {
        Node newnode = new Node(data);
        len++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    /* Add at Index */
    public void AddIndex(int data, int index) {
        if (index < 0 || index > len) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            AddFirst(data);
            return;
        }

        Node newnode = new Node(data);
        len++;
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    /* Print List */
    public void PrintList() {
        Node temp = head;
        System.out.print("Head -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /* Get Size */
    public static int size() {
        return len;
    }

    /* Remove First */
    public int RemoveFirst() {
        if (len == 0) return -1;
        int val = head.data;
        head = head.next;
        if (--len == 0) tail = null;
        return val;
    }

    /* Remove Last */
    public int RemoveLast() {
        if (len == 0) return -1;
        if (len == 1) {
            int val = head.data;
            head = tail = null;
            len--;
            return val;
        }
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        len--;
        return val;
    }

    /* Search Iteratively */
    public int Search(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    /* Search Recursively */
    private int helperfun(Node head, int key) {
        if (head == null) return -1;
        if (head.data == key) return 0;
        int idx = helperfun(head.next, key);
        return (idx == -1) ? -1 : idx + 1;
    }

    public int Search_2(int key) {
        return helperfun(head, key);
    }

    /* Reverse Linked List */
//    public void Reverse() {
//        Node prev = null, curr = head, next;
//        tail = head;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        head = prev;
//    }
    public void reverseList(){
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


    /* Remove Nth Node from End */
    public int removeNth_end(int index) {
        if (index > len) return -1;
        int sindex = len - index;
        if (sindex == 0) return RemoveFirst();

        Node prev = head;
        for (int i = 1; i < sindex; i++) prev = prev.next;
        int val = prev.next.data;
        prev.next = prev.next.next;
        if (--len == 0) tail = null;
        return val;
    }

    /* Check Palindrome */
    public boolean palindromeList() {
        if (head == null) return true;
        Node mid = findMid();

        // Reverse second half
        Node prev = null, curr = mid.next, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev, left = head;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /* Find Middle Node */
    public Node findMid() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* Detect Cycle */
    public boolean DetectLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    /* Remove Cycle */
    public void removeCycle() {
        Node slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return;

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    /* Merge Sort */
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = findMid();
        Node right = mid.next;
        mid.next = null;
        return merge(mergeSort(head), mergeSort(right));
    }

    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1), temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = (head1 != null) ? head1 : head2;
        return mergedLL.next;
    }

    /* Zig-Zag Linked List */
    public void ZigZaglist() {
        Node mid = findMid();
        Node prev = null, curr = mid.next, next;
        mid.next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head, right = prev;
        while (left != null && right != null) {
            Node nextL = left.next, nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }


//    // partition List
//    public Node partitionList(Node head , int x){
//        // Create two separate lists: one for nodes less than x and one for nodes greater or equal to x
//        Node leftHead = null, rightHead = null;
//       Node left = null, right = null;
//
//        Node temp = head; // Start traversing from the head
//
//        while (temp != null) {
//            if (temp.data < x) {
//                if (left == null) {
//                    leftHead = temp; // Initialize left list with the first node less than x
//                    left = leftHead;
//                } else {
//                    left.next = temp; // Add node to left list
//                    left = left.next;
//                }
//            } else {
//                if (right == null) {
//                    rightHead = temp; // Initialize right list with the first node greater than or equal to x
//                    right = rightHead;
//                } else {
//                    right.next = temp; // Add node to right list
//                    right = right.next;
//                }
//            }
//            temp = temp.next; // Move to the next node
//        }
//
//        // Combine the left and right lists
//        if (left == null) {
//            return rightHead; // No left part, return right part
//        }
//
//        left.next = rightHead; // Link the left list to the right list
//        if (right != null) {
//            right.next = null; // End the right list
//        }
//
//        return leftHead; // Return the head of the rearranged list
//    }
//

    public static void main(String[] args) {
        Linkedlist1 li = new Linkedlist1();
        li.AddLast(5);
        li.AddLast(2);
        li.AddLast(3);
        li.AddLast(5);
        li.AddLast(6);
        li.PrintList();
        //        li.ZigZaglist();
        //        li.reverseList();
        li.PrintList();
        //       li.partitionList(head,4);
        li.PrintList();

    }
}
