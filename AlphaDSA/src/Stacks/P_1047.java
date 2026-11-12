import java.util.Scanner;
import java.util.Stack;

public class P_1047 {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c); // Only push if it's not a duplicate
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter input string:");
        String input = scanner.nextLine();
        
        System.out.println("Enter expected string:");
        String input2 = scanner.nextLine();

        String fix = removeDuplicates(input);
        System.out.println("Result: " + fix);
        
        // Use .equals() for true/false content comparison
        System.out.println("Matches expected (.equals): " + fix.equals(input2));
        
        // Returns 0 if identical
        System.out.println("Lexicographical diff (.compareTo): " + fix.compareTo(input2));
        
        scanner.close();
    }
}
