package AlgorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class FruitsIntoBasket_P904 {
    static void main() {

        int k=2;
        int arr [] = {3,3,3,1,2,1,1,2,3,3,4};

        System.out.println("total fruits : "+totalFruit(arr,k));
    }

    public static int totalFruit(int[] fruits, int k) {
        int left =0,right = 0,maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right < fruits.length){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);


            if(map.size()>k){
                while(map.size()>k){
                    map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                    if(map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }

            if(map.size()<=k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}
