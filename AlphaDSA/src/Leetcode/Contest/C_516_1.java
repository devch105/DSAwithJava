package Leetcode.Contest;

public class C_516_1 {
    public static void main(String[] args) {
        System.out.println("Answer : " + isPalindromic("ff"));
    }

    public static boolean isPalindromic(String s) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int ascii = (int) ch;
            String bin = String.format("%8s", Integer.toBinaryString(ascii)).replace(' ', '0');
            str.append(bin);
        }
        String newstr = str.toString();
        String reverse = str.reverse().toString();
        return reverse.equals(newstr);
    }

}
