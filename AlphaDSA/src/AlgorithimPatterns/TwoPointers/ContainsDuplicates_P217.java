package AlgorithimPatterns.TwoPointers;

import java.util.HashMap;
import  java.util.Arrays;

public class ContainsDuplicates_P217 {
    static void main() {

        int arr[] = {237384,348185,338816,825359,461215,315112,170091,173609,724297,828355,395935,687922,127118,795454,166794,888047,274616,667202,772520,845914,142832,575527,980196,584061,784366,68694,80105,618370,915739,787506,379362,601205,44762,969018,625507,738640,900407,43638,477963,233716,613792,751212,231136,467042,514654,521610,369778,843173,257148,760274,234955,265546,891429,750091,942435,882691,485058,792360,435287,372065,396852,330275,801939,200914,455728,109280,527003,303337,793015,667734,279361,37810,783709,960454,33515,263864,624043,788379,449351,538850,706217,238925,353546,816968,654562,564565,948428,739868,861656,857587,418080,653483,909732,952407,927615,35267,732179,232870,933798,61900,147786,777833,294447,441553,819649,999015,523917,507135,9098,588245,831300,993003,945127,295861,806452,771032,921668,596114,58389,569490,199237,885193,713430,997040,349454,18832,365963,558789,793979,254667,902665,558387,193214,22187,589600,12593,959246,288997,790510,739049,415542,64949,504677,744804,344632};
        System.out.println("Answer : "+containsDuplicate(arr));

        System.out.println("Answer : "+containsDuplicateSort(arr));
    }

    // hashmap approach
    public static boolean containsDuplicate(int arr []){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
           if(map.containsKey(arr[i])){return true;}else {

               map.put(arr[i],map.getOrDefault(arr[i],0)+1);
           }
        }
        return false;
    }

    // sorting approach
    public static boolean containsDuplicateSort(int arr[]){
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                return true;
            }
        }
        return false;
    }
}
