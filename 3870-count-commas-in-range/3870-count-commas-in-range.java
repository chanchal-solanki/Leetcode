class Solution {
    public int countCommas(int n) {
        int n_copy = n;
        int count = 0; 

        while(n > 0) {
            count ++ ;
            n = n/10;
        }
       
        if(count < 4) return 0;
        return (n_copy - 1000) + 1 ;
    }
}