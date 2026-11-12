package Codeforces;

import java.util.Scanner;

public class P_1030A {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isHard = false;
        for(int i=0; i<n; i++){
            if(sc.nextInt() == 1){
                System.out.println("hard");
                isHard = true;
                break;
            }
        }
        if(!isHard){
            System.out.println("easy");
        }
    }
}
