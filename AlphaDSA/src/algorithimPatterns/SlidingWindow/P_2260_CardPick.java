package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class P_2260_CardPick {

    public static void main(String[] args) {
        int[] cardPoints = {70,37,70,41,1,62,71,49,38,50,29,76,29,41,22,66,88,18,85,53};
        System.out.println(maxScore(cardPoints));
    }

    public static int maxScore(int[] nums){
        int len=Integer.MAX_VALUE;
        int right=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(right < nums.length){ 
            if(map.containsKey(nums[right])){
                int prev = map.get(nums[right]);
                len = Math.min(len, right-prev+1);
                map.put(nums[right],right);
            }
             map.put(nums[right], right);
            right++;
        }
        return len==Integer.MAX_VALUE?-1:len;
    }
}
