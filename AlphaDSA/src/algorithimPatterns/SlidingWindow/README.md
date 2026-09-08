# Sliding Window

## Introduction

The sliding window technique is a commonly used algorithmic strategy for solving problems that involve arrays or lists.

This technique is particularly effective when dealing with problems related to subarrays or substrings. It involves maintaining a window that slides over the data structure to capture a subset of elements, which is then analyzed to solve the problem at hand.

## How Sliding Window Works

### 1. Fixed-Size Window

- A window of a fixed size moves from the beginning to the end of the array.
- At each step, the window captures a subset of the array's elements.
- This technique is used to find the maximum/minimum sum of subarrays of a fixed size, average of subarrays, etc.

### 2. Variable-Size Window

- The window size can change dynamically.
- This approach is useful when the window size is determined based on a condition that changes as you iterate through the array.
- It is often used in problems where you need to find the smallest or largest subarray that meets a certain condition, such as the sum being greater than a given value, or the number of distinct characters in a substring.

## Examples

### 1. Fixed-Size Window Example

**Problem:** Find the maximum sum of all subarrays of size `k` in an array.

**Approach:** To find the maximum sum of all subarrays of size `k` in an array using the sliding window technique in Java, we can follow the steps outlined below. The sliding window approach will help us achieve an optimal time complexity of `O(n)`.

#### Java Implementation

```java
public class SlidingWindowMaxSum {
    // Method to find the maximum sum of subarrays of size k
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            throw new IllegalArgumentException("Array length must be greater than or equal to k");
        }

        // Compute the sum of the first window of size k
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // Initialize the current window sum to the maxSum
        int windowSum = maxSum;

        // Slide the window from the start to the end of the array
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 8, 1, 1};
        int k = 3;
        System.out.println(
            "Maximum sum of subarrays of size " + k + " is " + maxSumSubarray(arr, k)
        );
    }
}
```

#### Explanation

1. **Initial Sum Calculation:** Calculate the sum of the initial window of size `k`. This gives us the initial maximum sum.
2. **Sliding the Window:** Slide the window across the array. For each new position:
   - Add the element that comes into the window: `arr[i]`.
   - Subtract the element that goes out of the window: `arr[i - k]`.
   - Update the maximum sum if the current window sum is greater than the previous maximum sum.

#### Time and Space Complexity

- **Time Complexity:** `O(n)`
  - Initial window calculation takes `O(k)`.
  - Sliding the remaining windows takes `O(n - k)`.
  - Overall complexity is `O(n)`.
- **Space Complexity:** `O(1)`

This implementation efficiently finds the maximum sum of all subarrays of size `k` using the sliding window technique.

---

### 2. Variable-Size Window Example

**Problem:** Find the smallest subarray with a sum greater than or equal to `S`.

**Approach:** Use a variable-size sliding window. The technique ensures that we only traverse the array once, achieving an optimal time complexity of `O(n)`.

#### Java Implementation

```java
public class SmallestSubarraySum {
    // Method to find the length of the smallest subarray with sum >= S
    public static int smallestSubarrayWithSum(int[] arr, int S) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            // Shrink the window while its sum is >= S
            while (currentSum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= arr[start];
                start++;
            }
        }

        // Return 0 if no valid subarray exists
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int S = 7;
        int result = smallestSubarrayWithSum(arr, S);

        System.out.println(
            "The length of the smallest subarray with sum >= " + S + " is " + result
        );
    }
}
```

#### Explanation

1. **Initialization:** Initialize `minLength` to `Integer.MAX_VALUE` to track the minimum length found. `currentSum` starts at `0`, and `start` is the left boundary of the window.
2. **Expanding the Window:** Iterate through the array with the `end` pointer and add the current element to `currentSum`.
3. **Shrinking the Window:** While `currentSum >= S`, shrink the window from the left by moving `start` to the right. Update `minLength` whenever a smaller valid window is found.
4. **Check and Return:** If `minLength` remains `Integer.MAX_VALUE`, no valid subarray was found, so return `0`. Otherwise, return `minLength`.

#### Time and Space Complexity

- **Time Complexity:** `O(n)` because each element is processed at most twice: once when expanding and once when shrinking.
- **Space Complexity:** `O(1)`

This implementation efficiently finds the length of the smallest subarray with a sum greater than or equal to `S`.

## Key Points

- **Efficiency:** The sliding window technique often reduces the time complexity of problems that would otherwise require nested loops, making it `O(n)` instead of `O(n²)`.
- **Applications:** It is widely used in string problems, subarray problems, and other scenarios where a contiguous subset of elements needs to be considered.
- **Adjustability:** The window can be adjusted dynamically, which is useful for problems where the size of the subset isn't fixed.

By understanding and implementing the sliding window technique, you can solve a wide range of problems more efficiently and effectively.

---

## LeetCode Example: 632. Smallest Range Covering Elements from K Lists

To solve the problem of finding the smallest range that includes at least one number from each of `k` sorted lists, you can use a min-heap (priority queue) combined with a sliding window approach.

> The source notes that this solution was coded with ChatGPT.

### Algorithm Explanation

1. **Initialization**
   - Use a min-heap (`PriorityQueue`) to keep track of the smallest element among the current elements of each list.
   - Track the maximum element among the current elements of each list.
   - Keep pointers to the current index of each list.

2. **Heap Operations**
   - Insert the first element of each list into the min-heap along with its list index.
   - Maintain a variable to track the maximum element in the current window.

3. **Sliding Window**
   - Extract the minimum element from the heap.
   - Calculate the current range as the difference between the maximum and minimum elements.
   - Update the smallest range if the current range is smaller.
   - Move the pointer of the list from which the minimum element was extracted and add the next element from that list to the heap.
   - Continue until one of the lists is exhausted.

4. **Termination**
   - The process terminates when one of the lists is exhausted because you can no longer form a range that includes at least one number from each list.

### Time and Space Complexity

- **Time Complexity:** `O(n log k)`, where `n` is the total number of elements across all lists and `k` is the number of lists.
- **Space Complexity:** `O(k)` because the heap stores one element from each of the `k` lists.

### Java Implementation

```java
import java.util.*;

public class SmallestRangeFinder {

    static class Node {
        int value;
        int listIndex;
        int elementIndex;

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int[] findSmallestRange(List<List<Integer>> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(n -> n.value)
        );

        int max = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Initialize the heap with the first element from each list
        for (int i = 0; i < lists.size(); i++) {
            int value = lists.get(i).get(0);
            minHeap.offer(new Node(value, i, 0));
            max = Math.max(max, value);
        }

        while (true) {
            // Get the minimum element from the heap
            Node minNode = minHeap.poll();
            int min = minNode.value;
            int listIndex = minNode.listIndex;
            int elementIndex = minNode.elementIndex;

            // Update the range if the current range is smaller
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // If we have reached the end of one of the lists, we can't continue
            if (elementIndex + 1 >= lists.get(listIndex).size()) {
                break;
            }

            // Move to the next element in the list
            int nextValue = lists.get(listIndex).get(elementIndex + 1);
            minHeap.offer(new Node(nextValue, listIndex, elementIndex + 1));
            max = Math.max(max, nextValue);
        }

        return new int[] {rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        );

        int[] result = findSmallestRange(lists);
        System.out.println(
            "Smallest range is [" + result[0] + ", " + result[1] + "]"
        );
    }
}
```

### Explanation of the Code

- **Node Class:** Stores the value of an element, its list index, and its position within the list.
- **Heap Initialization:** The heap is initialized with the first element from each list.
- **Heap Operations:** Extract the minimum element, update the range if necessary, and add the next element from the same list to the heap.
- **Termination:** The loop continues until one of the lists is exhausted, ensuring the smallest range is found.

This approach efficiently finds the smallest range that includes at least one number from each of the `k` sorted lists.
