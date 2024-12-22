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


     /*

      int sum=0;                    1. -> 0 unit
      int n=9;                      2. -> 0 unit
      for(int i=0; i<=n; i++){      3. -> n+1 unit -> (i<=n)   n unit ->(i<n)
          if((i%2)==0){             4. ->n unit
             sum+=i;                5. -> n/2 units
          }                         6. ->  0 units
          sum=sum+i;                4. -> 0 unit
      }                             5. -> 0 unit
        System.out.println(sum);    6. -> 0 unit

          combine units T(c) -> n + (n/2) + (n+1)  units
           all T(c)   N uints
      */

    public static void main(String[] args) {
      int sum=0;
      int n=10;
      for(int i=1; i<=n; i++){
          sum=sum+i;
      }
        System.out.println(sum);

    }

}
