package algorithimPatterns.SlidingWindow;

public class P_1052_GrumpyBookStoreOwner {
    public static void main(String[] args) {
        
     int []  customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
     int minutes = 3;

        System.out.println("Answer : "+maxSatisfied(customers, grumpy, minutes));
        System.out.println("Answer : "+newMaxSatisfied(customers, grumpy, minutes));
    }
    public static  int newMaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happyCustomers =0;
        for(int i=0; i<customers.length; i++){
            if(grumpy[i]==0){
                happyCustomers+=customers[i];
            }
        }

        int gain[] = new int[customers.length];
        for(int i=0; i<gain.length; i++){
            if(grumpy[i]==1){
                gain[i]=customers[i];
            }else{
                gain[i]=0;
            }
        }
        return fetchSatisfiedCustomers(gain,happyCustomers,minutes);
    }

    public static  int fetchSatisfiedCustomers(int gain[], int happyCustomers,int minutes){
        int left =0,right=0,max=-1;
        int currSum=0;
        while(right<gain.length){
            currSum += gain[right];

            if(right-left+1 > minutes){
                currSum-=gain[left];
                left++;
            }
            max=Math.max(max,currSum);
            right++;
        }
        return happyCustomers+max;
    }

    public static int maxSatisfied(int [] customers, int [] grumpy, int minutes){
      
        int happyCustomer = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                happyCustomer+=customers[i];
            }
        }
        
        int satisfied = 0;
        int left=0,right=0;
        int extraSatisfied = 0;
        while(right<customers.length){
           if(grumpy[right]==1){
            satisfied += customers[right];
           }
           
           if(right-left+1>minutes){
                if(grumpy[left]==1){
                    satisfied -= customers[left];
                }
                left++;
           }

           extraSatisfied = Math.max(extraSatisfied, satisfied);
           right++;
         }
        
        return happyCustomer + extraSatisfied;
    }
}
