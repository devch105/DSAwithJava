package Recursion;

public class RemoveDuplicates {
    public static void main(String[] args) {
        boolean arr[] = new boolean[26];
        StringBuilder str = new StringBuilder();
        removeduplicates("deveile", 0, str, arr);
    }

    private static void removeduplicates(String given,
                                         int idx, StringBuilder str,
                                         boolean[] map) {
        //base
        if (idx == given.length()){
            System.out.println("->" + str);
            return;
        }
        //kaam
        char currchar=given.charAt(idx);
        if(map[currchar-'a']==true){
            removeduplicates(given,idx+1,str,map);
        }else {
            map[currchar-'a']=true;
            str.append(currchar);
            removeduplicates(given,idx+1,str,map);
        }
    }
}