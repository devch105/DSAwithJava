package POTD.Jan.Leetcode;

public class P_2683 {
    public static boolean doesValidArrayExist(int[] derived) {
       int n=derived.length;
       int resout=0;
        for(int i=0; i<n; i++){
          resout^=derived[i];
        }
        return (resout==0)?true:false;
    }
    public static void main(String[] args) {
        int derived[] = {1,1,0};
        System.out.println("Answer : "+doesValidArrayExist(derived));
    }
}
