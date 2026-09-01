class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr =-1;
        int sc= -1;
        int [][] litterIdx = new int[m][n];
    
        for(int[] l : litterIdx) Arrays.fill(l,-1);
        
        int idx = 0;
        for(int i =0; i<m; i++){
            for(int j= 0; j<n; j++){
                if(classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } 
                if(classroom[i].charAt(j) == 'L'){
                    litterIdx[i][j] = idx++;
                }
            }
        }

        if(idx == 0) return 0 ;
        
        int cost = 0;
        int mask =  1<<idx;
        int fullMask = mask-1;

        Queue<int []> q = new LinkedList<>();

        q.offer(new int[]{sr,sc,energy,0});

        int [][] directions  = {{-1,0} , {0,1} ,{0,-1} ,{1,0}};

        int [][][] best = new int[m][n][mask];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(best[i][j], -1);
            }
        }
        
        best[sr][sc][0] = energy;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] cell = q.poll();

                int r = cell[0];
                int c = cell[1];
                int  currEnergy = cell[2];
                int currMask = cell[3];

                if(currMask == fullMask ) return cost;
                if(currEnergy == 0) continue;
               
                for(int[] dir : directions){
                    int nr = r+dir[0];
                    int nc = c+dir[1];

                    if(nr<0 || nr >= m || nc<0 || nc >= n ) continue;
                    if(classroom[nr].charAt(nc) == 'X' ) continue;

                    int newMask = currMask;
                    int newEnergy = currEnergy-1;

                    char val = classroom[nr].charAt(nc);
                    if(val == 'R') newEnergy = energy;

                    if(val == 'L'){ 
                        newMask |= (1 << litterIdx[nr][nc]);
                    }

                    if(newEnergy <= best[nr][nc][newMask]) continue;

                    best[nr][nc][newMask] = newEnergy ;
                
                    q.offer(new int[] {nr,nc,newEnergy ,newMask });
                }
            }
            cost++;
        }
        return -1 ;
    }
}