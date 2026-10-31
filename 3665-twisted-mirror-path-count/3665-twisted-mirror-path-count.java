class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // int[][][] dp =new int[m][n][2];

        // for(int[][] r : dp ){
        //     for(int[] c : r){
        //         Arrays.fill(c,-1);
        //     }
        // }

        return uniquePath(grid);
    }
    // public int dfs(int i ,int j , int path ,int[][] grid,int[][][] dp){
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int MOD = 1_000_000_007;

    //     if(i >= m || j >= n) return 0;
    //     if(i == m-1 && j == n-1) return 1;

    //     if(dp[i][j][path] != -1) return dp[i][j][path];

    //     int cnt = 0;

    //     if(grid[i][j] == 1){
    //         if(path == 1) cnt += dfs(i+1,j,0,grid,dp);
    //         else cnt += dfs(i,j+1,1,grid,dp);
    //     }else {
    //         cnt += dfs(i,j+1,1,grid,dp) + dfs(i+1,j,0,grid,dp);
    //     }
    //     return dp[i][j][path] = cnt % MOD ;
    // }

    

    public int uniquePath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] dp = new int[m + 1][n + 1][2];

        dp[m - 1][n - 1][0] = 1;
        dp[m - 1][n - 1][1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) continue;

                for (int d = 0; d < 2; d++) {
                    int ways;

                    if (grid[i][j] == 1) {
                        ways = (d == 1) ? dp[i + 1][j][0]
                                        : dp[i][j + 1][1];
                    } else {
                        ways = dp[i + 1][j][0] + dp[i][j + 1][1];
                    }

                    dp[i][j][d] = ways % MOD;
                }   
            }
        }

    return dp[0][0][0];
}

}