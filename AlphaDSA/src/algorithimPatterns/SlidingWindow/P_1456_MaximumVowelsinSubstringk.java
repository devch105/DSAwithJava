package algorithimPatterns.SlidingWindow;

public class P_1456_MaximumVowelsinSubstringk {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("Answer : "+maxVowels(s, k));
    }

    public static int maxVowels(String s, int k){
        int left=0,right=0;
        int count=0;
        int maxCount=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
            
            if(right-left+1>k){
                char ch1 = s.charAt(left);
                if(ch1=='a' || ch1=='e'|| ch1=='i' || ch1=='o' || ch1=='u'){
                count--;
                 }
                 left++;
            }
            maxCount = Math.max(maxCount, count);
            right++;
        }
        return maxCount;
    }
}
