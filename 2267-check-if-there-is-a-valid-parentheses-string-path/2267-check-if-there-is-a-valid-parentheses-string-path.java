class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // The maximum possible balance is m + n
        int[][][] dp = new int[m][n][m + n + 1];
        return checkPath(0, 0, 0, m, n, grid, dp);
    }

    public boolean checkPath(int i, int j, int balance, int m, int n, char[][] grid, int[][][] dp) {
        // 1. Boundary check for grid dimensions
        if (i >= m || j >= n) return false;
        
        // 2. Update the balance based on current cell
        if (grid[i][j] == '(') balance++;
        else balance--;

        // 3. Validate balance boundaries before accessing the DP array
        if (balance < 0 || balance >= dp[0][0].length) return false;

        // 4. Base Case: Reached the bottom-right corner
        if (i == m - 1 && j == n - 1) return balance == 0;

        // 5. Return memoized result if already visited (1 = true, 2 = false)
        if (dp[i][j][balance] != 0) return dp[i][j][balance] == 1;

        // 6. Recurse down and right
        boolean down = checkPath(i + 1, j, balance, m, n, grid, dp);
        boolean right = checkPath(i, j + 1, balance, m, n, grid, dp);
        
        boolean result = down || right;

        // 7. Memoize the result
        dp[i][j][balance] = result ? 1 : 2;
        return result;
    }
}
