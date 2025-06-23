package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {
    public static ArrayList<Integer> stockspan(int stock[]){
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> l1 = new ArrayList<>();

        // First element always has a span of 1
        s.push(0);
        l1.add(1);

        for (int i = 1; i < stock.length; i++) {
            // Pop elements from stack while stack is not empty and current stock price is greater than stack's top element
            while (!s.isEmpty() && stock[i] >= stock[s.peek()]) {
                s.pop();
            }

            // If stack becomes empty, it means no previous stock price is greater
            if (s.isEmpty()) {
                l1.add(i + 1);
            } else {
                l1.add(i - s.peek());
            }

            // Push current index to stack
            s.push(i);
        }
        return l1;
    }

    public static void main(String[] args) {
        int stock[] = {100, 80, 60, 70, 60, 85, 100};

        System.out.println("--> " + stockspan(stock));
    }
}
