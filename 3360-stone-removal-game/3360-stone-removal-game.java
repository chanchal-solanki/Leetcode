class Solution {
    public boolean canAliceWin(int n) {
        // int take = n;
        int alice = 10 , bob = 9;

        while(n > 0) {
            if(alice>n) return false;
            n -= alice ;
            alice -= 2;
           
            if(bob > n) return true;
            n -= bob;
            bob -= 2;
        }
        return false;
    }
}