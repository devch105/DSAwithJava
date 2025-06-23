package Stacks;

import java.util.Stack;

public class MaxAreaInHistogram {
    public static void MaxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length]; // Next Smaller Right
        int nsl[] = new int[arr.length]; // Next Smaller Left
        Stack<Integer> s = new Stack<>();

        // Next Smaller Right (NSR)
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsr[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }

        // Next Smaller Left (NSL)
        s.clear(); // Instead of reinitializing, just clear the stack
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        // Calculate Max Area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1; // Width = NSR - NSL - 1
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }
        System.out.println("Max Area in Histogram: " + maxArea);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        MaxArea(arr);
    }
}
