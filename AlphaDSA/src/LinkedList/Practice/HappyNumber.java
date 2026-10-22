package LinkedList.Practice;

public class HappyNumber {
    public static void main(String[] args) {
         int x = 23;
         System.out.println("Answer : "+getHappy(x));
    }

    public static boolean getHappy(int n){
        int slow=n, fast =n;
        while (true) {
            slow = getNextNum(slow);
            fast =getNextNum(getNextNum(fast));

            if(fast == 1){
                return  true;
            }else if(fast == slow){
                return false;
            }
        }

    }

    public static  int getNextNum(int n){
        int nextNum=0;
        while (n>0) {
            int digit = n%10;
            n/=10;
            nextNum+=digit*digit;
        }
        return nextNum;
    }
}
