class Solution {
    public boolean isHappy(int n) {
        int sumOfSq = 10;

        while(sumOfSq>9){
            sumOfSq = 0;
            while(n>0){
                int digit = n%10;
                sumOfSq += digit*digit;
                n=n/10;
            } 
            n = sumOfSq;  
            
        }
        return (sumOfSq == 1 ||  sumOfSq == 7) ? true : false;
    }
}