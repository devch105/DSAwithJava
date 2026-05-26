package algorithimPatterns.SlidingWindow;

public class P_1052_GrumpyBookStoreOwner {
    public static void main(String[] args) {
        
     int []  customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
     int minutes = 3;

        System.out.println("Answer : "+maxSatisfied(customers, grumpy, minutes));
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
