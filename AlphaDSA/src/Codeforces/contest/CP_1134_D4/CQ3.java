package Codeforces.contest.CP_1134_D4;

import java.util.*;

public class CQ3
 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> middle = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            // freq count kro 
            int i = 0;

            while (i < n) {

                int j = i;

                while (j < n && arr[i] == arr[j]) {
                    j++;
                }

                int freq = j - i;

                left.add(arr[i]);

               
                if (freq >= 2) {
                    right.add(arr[i]);
                }

               
                for (int k = 2; k < freq; k++) {
                    middle.add(arr[i]);
                }

                i = j;
            }

           
            Collections.reverse(right);

            int ans = left.size() + right.size();

            System.out.println(ans);

            
            StringBuilder sb = new StringBuilder();

            for (int x : left) {
                sb.append(x).append(" ");
            }

            for (int x : middle) {
                sb.append(x).append(" ");
            }

            for (int x : right) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
