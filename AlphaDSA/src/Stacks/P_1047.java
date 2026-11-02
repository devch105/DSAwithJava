package Stacks;

import Stacks.StacksviaArrayList.Stacks;

public class P_1047 {

    // Remove all adjacent duplicates in string
    public static String removeDuplicates(String s) {
        Stacks stack = new Stacks();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append((char) stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a string to remove adjacent duplicates:");
        String input = scanner.nextLine();
        System.out.println("Result: " + removeDuplicates(input));
    }
}
