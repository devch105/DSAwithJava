package POTD.Jan.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class P_2559 {

    public  static int[] vowelStrings(String[] words, int[][] queries) {

        int n=words.length;
        int prefixsum[]=new int[n];

        prefixsum[0]=isVowel(words[0]);
        for(int i=1; i<n; i++){
            prefixsum[i]=prefixsum[i-1]+isVowel(words[i]);

        }
        int res[]=new int[queries.length];
        for (int i=0;i< queries.length; i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int ans=prefixsum[r];
            if (l != 0) {
                ans-=prefixsum[l-1];
            }
            res[i]=ans;
        }
         return  res;
    }

    public static int isVowel(String word){
        HashSet<Character>set=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        if(set.contains(first)&& set.contains(last)){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] word={"aba","bcb","ece","aa","e"};
      int [][]  queries = {{0,2},{1,4},{1,1}};
     int arr[]=vowelStrings(word,queries);
        System.out.println("Answer : "+Arrays.toString(arr));
    }
}
