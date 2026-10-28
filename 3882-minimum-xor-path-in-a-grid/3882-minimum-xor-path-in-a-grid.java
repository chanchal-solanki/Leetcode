class Solution {
    int ans = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] visited = new boolean[m][n][1024];
        dfs(0,0,0,grid,visited); 

        return ans;   
    }
    public void dfs(int i, int j, int xor, int[][] grid,boolean[][][] visited){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n) return;
        if(visited[i][j][xor]) return;

        visited[i][j][xor] = true;

        xor ^= grid[i][j];

        if(i == m-1 && j == n-1 ) {
            ans = Math.min(ans,xor);
        }

        dfs(i+1,j,xor,grid,visited);
        dfs(i,j+1,xor, grid,visited);

    }
}