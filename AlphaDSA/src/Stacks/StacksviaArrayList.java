package Stacks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StacksviaArrayList {
    static class Stacks {
        private ArrayList<Integer> l1 = new ArrayList<>();
        private int top = -1;

        public boolean isEmpty() {
            return l1.isEmpty();
        }

        //** Push operation
        public void push(int data) {
            l1.add(data);
            top++;
        }

        //** Pop operation
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int el = l1.remove(top);
            top--;
            return el;
        }

        // ** Peek operation
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return l1.get(top);
        }


    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stacks s = new Stacks(); // Moved outside loop

        while (true) {
            System.out.println("\nEnter choice:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");

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
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
