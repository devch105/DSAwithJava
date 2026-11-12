package Codeforces;

import java.util.HashSet;
import java.util.Scanner;

public class ABeautifulYear {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Example input year
        int year = sc.nextInt();
        System.out.println(nextBeautifulYear(year));
    }

    public static int nextBeautifulYear(int year) {
        year++;
        while (!isUnique(year)) {
            year++;
        }
        return year;
    }

    public static boolean isUnique(int year) {
        HashSet<Integer> set = new HashSet<>();
        while (year > 0) {
            int digit = year % 10;
            if (set.contains(digit)) {
                return false;
            } 
            set.add(digit);
            
            year /= 10;
        }
        return true;
    }

}
