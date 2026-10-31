class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp =new int[m][n][2];

        for(int[][] r : dp ){
            for(int[] c : r){
                Arrays.fill(c,-1);
            }
        }

        return dfs(0,0,0,grid,dp);
    }
    public int dfs(int i ,int j , int path ,int[][] grid,int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j][path] != -1) return dp[i][j][path];

        int cnt = 0;

        if(grid[i][j] == 1){
            if(path == 1) cnt += dfs(i+1,j,0,grid,dp);
            else cnt += dfs(i,j+1,1,grid,dp);
        }else {
            cnt += dfs(i,j+1,1,grid,dp) + dfs(i+1,j,0,grid,dp);
        }
        return dp[i][j][path] = cnt % MOD ;
    }
}