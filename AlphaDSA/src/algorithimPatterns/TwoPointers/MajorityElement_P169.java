package algorithimPatterns.TwoPointers;

public class MajorityElement_P169 {
    static void main() {
        int arr[] ={2,2,1,3,3,1,2,2};
        System.out.println("Answer : "+majorityElement(arr));

    }
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int votes = 1;

        for(int i=1; i<nums.length;i++){
            if(nums[i] == candidate){
                votes++;
            }else{
                votes--;
                if(votes==0){
                    candidate = nums[i];
                    votes=1;
                }
            }
        }
        return candidate;
    }

}
