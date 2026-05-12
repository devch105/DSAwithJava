package AlgorithimPatterns.TwoPointers;

public class MaxDistanceBwPairofValues {
    static void main() {
        int arr1[] = {55,30,5,4,2};
        int arr2[] = {100,20,10,10,5};

        System.out.println("Answer : "+maxDistance(arr1,arr2));
    }


    public static int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance =0;

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                //valid pair

                if(i<=j && nums1[i]<nums2[j]){

                    // maxDistance

                    maxDistance = Math.max(j-i,maxDistance);
                }
            }
        }
        return maxDistance;
    }
}
