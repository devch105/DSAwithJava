package LinkedList.Practice;

import LinkedList.Linkedlist1;

public class PartitionList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Linkedlist1.Node head;
    public static Linkedlist1.Node tail;
    public static int len = 0;

    //           1-> 4-> 3 -> 2 -> 5 ->2
//     x=3   1-> 2 -> 2->
    public Node partitionList(Node head, int x) {
        // Create two separate lists: one for nodes less than x and one for nodes greater or equal to x
        Node leftHead = null, rightHead = null;
        Node left = null, right = null;

        Node temp = head; // Start traversing from the head

        while (temp != null) {
            if (temp.data < x) {
                if (left == null) {
                    leftHead = temp; // Initialize left list with the first node less than x
                    left = leftHead;
                } else {
                    left.next = temp; // Add node to left list
                    left = left.next;
                }
            } else {
                if (right == null) {
                    rightHead = temp; // Initialize right list with the first node greater than or equal to x
                    right = rightHead;
                } else {
                    right.next = temp; // Add node to right list
                    right = right.next;
                }
            }
            temp = temp.next; // Move to the next node
        }

        // Combine the left and right lists
        if (left == null) {
            return rightHead; // No left part, return right part
        }
        left.next = rightHead; // Link the left list to the right list
        if (right != null) {
            right.next = null; // End the right list
        }

        return leftHead; // Return the head of the rearranged list
    }
}