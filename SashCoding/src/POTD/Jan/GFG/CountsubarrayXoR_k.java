package POTD.Jan.GFG;

import java.util.HashMap;

public class CountsubarrayXoR_k {
    public static long subarrayXor(int arr[], int k) {
        // Map to store the frequency of XOR values
        HashMap<Integer, Integer> hm = new HashMap<>();
        int xor = 0;
        int count = 0;

        for (int x : arr) {
            // Calculate XOR up to the current element
            xor ^= x;

            // If the XOR itself equals k, increment count
            if (xor == k) {
                count++;
            }

            // Check if (xor ^ k) exists in the map
            int target = xor ^ k;
            count += hm.getOrDefault(target, 0);

            // Update the frequency map
            hm.put(xor, hm.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[]={4,2,2,6,4};
        System.out.println(" Answer : "+subarrayXor(arr,6));
    }
}
