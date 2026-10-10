class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] mat = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                mat[i][j] = board[i][j];
            }
        }

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                int count = countLive(i,j,mat);

                if(mat[i][j] == 0){
                    if(count == 3 ) board[i][j] = 1;
                }else{
                     if(!(count == 2 || count == 3 ))  board[i][j] = 0;
                }   
            }
        }
    }
    // public boolean check(int i , int j, int board[][]){
    //     if(i < 0 || j < 0 || i<board.length || j>board[0].length) return false;
    //    return true;

    // }

    public int countLive(int r , int c, int board[][]){
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1},
        {1,1},{-1,-1},{-1,1},{1,-1}};
        int cnt = 0;

        for(int[] d : dir){
            int i = r+d[0];
            int j = c+d[1];

            if(i < 0 || j < 0 || i>=board.length || j>=board[0].length) continue;

            if(board[i][j] == 1) cnt += 1;
        }
        return cnt;
    }
}