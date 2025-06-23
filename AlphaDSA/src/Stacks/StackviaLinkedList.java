package Stacks;

import java.util.Scanner;

public class StackviaLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stacks {
        private Node head = null; // Removed static to make it instance-specific

        // Check if stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Push element onto stack
        public void push(int data) {
            Node newnode = new Node(data);
            newnode.next = head;
            head = newnode;
        }

        // Pop element from stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek (top element)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.data;
        }

        // Print stack elements
        public void printStack() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            System.out.println("Stack : ");
            Node temp = head;
            while (temp != null) {
                System.out.println("|"+temp.data +"| ");
                temp = temp.next;
            }
            System.out.println();
        }
//        ** PUSH AN ELEMENT TO BOTTOM OF STACK ??
        private void pushtobottomStack(Stacks s, int data) {
            if (s.isEmpty()) {
                s.push(data);
                return;
            }

            int temp = s.pop();
            pushtobottomStack(s, data);
            s.push(temp);
        }

//        ** Reverse Stack
        public void reversestack(Stacks s) {
            if (s.isEmpty()) {
                return;
            }

            int top = s.pop();
            reversestack(s);

            pushtobottomStack(s, top);
        }

    }
    public static void main(String[] args) {
        Stacks s = new Stacks();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter choice:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Push to Bottom");
            System.out.println("6. Exit");
            System.out.println("7. Reverse given stack");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Data:");
                    int data = sc.nextInt();
                    s.push(data);
                    break;
                case 2:
                    System.out.println("Popped: " + s.pop());
                    break;
                case 3:
                    System.out.println("Peek: " + s.peek());
                    break;
                case 4:
                    s.printStack();
                    break;

                case 5:
                    System.out.println("Enter Data:");
                    int val= sc.nextInt();
                    s.pushtobottomStack( s, val);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                case 7: s.reversestack(s);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
