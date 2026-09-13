class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        ArrayList<int[]> one_img1 = new ArrayList<>();
        ArrayList<int[]> one_img2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j] == 1) one_img1.add(new int[]{i,j});
                if(img2[i][j] == 1) one_img2.add(new int[]{i,j});
            }
        }

        int overlap =0;
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for(int [] cord1 : one_img1){
            for(int [] cord2 : one_img2){
                int dx = cord2[0]-cord1[0];
                int dy = cord2[1] - cord1[1];

                List<Integer> key = Arrays.asList(dx, dy); ;
                map.put( key,map.getOrDefault(key,0)+1 );
                overlap = Math.max(map.get(key),overlap);
            }
        }
        return overlap;
    }
}