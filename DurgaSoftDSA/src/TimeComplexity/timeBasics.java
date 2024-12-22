package TimeComplexity;

public class timeBasics {
    /*

      int sum=0;                    1. -> 0 unit
      int n=9;                      1. -> 0 unit
      for(int i=0; i<=n; i++){      1. -> n+1 unit -> (i<=n)   n unit ->(i<n)
          sum=sum+i;                1. -> 0 unit
      }                             1. -> 0 unit
        System.out.println(sum);    1. -> 0 unit

          combine units T(c) -> N units
     */


    public static void main(String[] args) {
      int sum=0;
      int n=9;
      for(int i=0; i<=n; i++){
          sum=sum+i;
      }
        System.out.println(sum);

    }

}
