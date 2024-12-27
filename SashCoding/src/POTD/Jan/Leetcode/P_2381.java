package POTD.Jan.Leetcode;

public class P_2381 {
    public static String shiftingLetters(String s, int[][] shifts) {
       // Line Sweep Algo:
        int n = s.length();
        int[] arr = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) { //fw
                arr[shift[0]]++;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]--;
                }
            } else { //bw
                arr[shift[0]]--;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]++;
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % 26;
            if (sum < 0) sum += 26;
            char shiftedChar = (char) ('a' +
                    ((s.charAt(i) - 'a' + sum) % 26));
            result.setCharAt(i, shiftedChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String s="abc";
        int shifts[][]={{0,1,0},{1,2,1},{0,2,1}};

        System.out.println("Answer : "+shiftingLetters(s,shifts));

    }
}
