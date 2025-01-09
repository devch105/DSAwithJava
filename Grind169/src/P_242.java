import java.util.Arrays;

public class P_242 {
    public static boolean isAnagram(String s, String t) {
        char []arr1=s.toCharArray();
        char []arr2=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1)+" ---- "+Arrays.toString(arr2));
        if(arr1.length!=arr2.length){
            return false;
        }else{
            for(int i=0; i<arr1.length; i++){
                if(arr1[i]!=arr2[i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
       String s = "car", t = "rat";
        System.out.println("Answer : "+isAnagram(s,t));
    }
}
