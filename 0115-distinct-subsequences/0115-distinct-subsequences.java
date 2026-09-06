class Solution {
    public int numDistinct(String s, String t) {
        return findWays(s,t);
    }

    // public int findWays(int i, int j, String s , String t){
    //     if(j == t.length()) return 1;
    //     if(i == s.length()) return 0;

    //     int take = 0;
    //     if(s.charAt(i) == t.charAt(j)) take = findWays(i+1, j+1,s,t);

    //     int not_take = findWays(i+1,j,s,t);
    //     return take + not_take;
    // }

    public int findWays(String s , String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) dp[i][m] = 1;

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                
                else 
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }

}