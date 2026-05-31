package algorithimPatterns.BinarySearch;

import java.util.HashMap;

public class ContainsDuplicate2nd {
    public static void main(String[] args) {
        System.out.println("Answer : "+containsDuplicates(new int [] {1,2,3,1,2,3}, 2));
    }
    public static boolean containsDuplicates(int arr [], int k ){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){

            if(map.containsKey(arr[i])){
                if(Math.abs(i-map.get(arr[i]))<=k)return true;
            }
            map.put(arr[i],i);
        }
        return false;
    }

}
