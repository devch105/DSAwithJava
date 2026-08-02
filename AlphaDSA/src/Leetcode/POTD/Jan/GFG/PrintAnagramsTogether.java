package POTD.Jan.GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAnagramsTogether {
    public  static  ArrayList<List<String>> anagrams(String[] arr) {
        // code here
        HashMap <String, List<String>> hm=new HashMap<>();
        ArrayList<ArrayList<String>> Result=new ArrayList<>();

        for(String s:arr){

            char tempchar[]=s.toCharArray();
            Arrays.sort(tempchar);

            String sortword=String.valueOf(tempchar);

            if(!hm.containsKey(sortword)){
                hm.put(sortword,new ArrayList<>());
            }
            hm.get(sortword).add(s);
        }
        return new ArrayList<>(hm.values());

    }

    public static void main(String[] args) {

        String arr[] = {"act", "god", "cat", "dog", "tac"};

        System.out.println("Answer : "+anagrams(arr));
    }
}
