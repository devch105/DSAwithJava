package Arrays;

public class Array_SUM_Operations {

    // Q1 : Sum of Array :
    static int sumofArray(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    // Q2 : Sum of element at Even Index
     static  int sumofArrayEvenIndex(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(i%2==0){
                sum+=arr[i];
            }
        }
        return sum;
     }

     //Q3: Sum of Element at Odd Index
     static  int sumofArrayOddIndex(int arr[]){
         int sum=0;
         for(int i=0; i<arr.length; i++){
             if(i%2!=0){
                 sum+=arr[i];
             }
         }
         return sum;
     }

     //Q4: sum of all positive

    static int sumofAllPositive(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    // Q5 : sum of All Negative

    static int sumofAllNegative(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    //Q6 : sum of element divisible by both 2 and 3

    static  int sumofdivisibleBy_2_3(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0 && arr[i]%3==0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    // Q7: sum of all prime Numbers in Array
    static boolean isPrime(int n, int divisor) {
        if (n <= 1) {
            return false;
        }
        if (divisor == 1) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor - 1);
    }
    // Wrapper function to initiate the recursive check
    static boolean isPrimenum(int n) {
        return isPrime(n, n / 2); // Start checking from n/2
    }

    // Function to sum all prime numbers in an array
    static int sumOfPrimes(int arr[]) {
        int sum = 0;
        for (int num : arr) {
            if (isPrimenum(num)) {
                sum += num;
            }
        }
        return sum;
    }



    //Q9 : sum of all element factorial :

    static int factorialofNum(int n){
        if(n==0 || n==1){
            return 1;
        }else return n*factorialofNum(n-1);
    }

    static int sumOfallFactorial(int arr[]) {
        int sum = 0;
        for (int num : arr) {
            int temp=factorialofNum(num);
            sum+=temp;
        }
        return sum;
    }


    public static void main(String[] args) {
        int arr[]={2,-1,4,-4,5,-6,9};
         int arr1[]={4,3,2,8,5};
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofArray(arr));
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofArrayOddIndex(arr));
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofArrayEvenIndex(arr) );
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumOfPrimes(arr));
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofAllNegative(arr));
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofdivisibleBy_2_3(arr));
        System.out.println("-------------------------");
        System.out.println("Answer : "+sumofAllPositive(arr));
        System.out.println("-------------------------");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("Answer : "+sumOfallFactorial(arr1));
    }
}
