package algorithimPatterns.SlidingWindow;

public class P_1208_GetEqualSubstringWithinBudget {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));

    }

    public static int equalSubstring(String s , String t , int maxCost){
        int left =0;
        int right =0;
        int cost =0;
        int maxLength  = Integer.MIN_VALUE;

        while(right<s.length()){
            cost +=Math.abs(s.charAt(right)-t.charAt(right));
            while(cost>maxCost){
                cost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
