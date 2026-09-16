class Solution {
    int MOD = 1000000007; 
    public int numberOfSets(int n, int k) {
        return solve(k,n);
    }

    // tabulation
    public int solve(int k_n, int n ){
        int[][][] dp = new int[n+1][k_n+1][2];

        for(int i =0; i<n; i++){
            dp[i][0][0] = 1;
            dp[i][0][1] = 1;
        }

        for(int i=n-1; i>=0; i--){
            for(int k=1; k <= k_n; k++){
                
                dp[i][k][0] = (dp[i+1][k][1] + dp[i+1][k][0])%MOD;
                dp[i][k][1] = (dp[i+1][k][1] + dp[i][k-1][0])%MOD;
            }
        }
        return dp[0][k_n][0];
    }

    // Memoization
    // public int solve(int i, int k, int idx , int n ,int dp[][][]){
    //     if(k == 0) return 1;
    //     if(i == n) return 0;

    //     if(dp[i][k][idx] != -1) return dp[i][k][idx] ;
    //     if(idx == 0)  
    //         return dp[i][k][idx] = (solve(i+1,k,0,n,dp)+solve(i+1,k,1,n,dp))%MOD;
        
    //     return  dp[i][k][idx] = (solve(i,k-1,0,n,dp)+solve(i+1,k,1,n,dp))%MOD;
    // }

    //****Recursion****
    // public int solve(int i, int k, int idx , int n){
    //     if(k == 0) return 1;
    //     if(i == n) return 0;

    //     if(idx == 0) 
    //         return (solve(i+1,k,0,n)+solve(i+1,k,1,n))%MOD;
        
    //     return  (solve(i,k-1,0,n)+solve(i+1,k,1,n))%MOD;
    // }
}