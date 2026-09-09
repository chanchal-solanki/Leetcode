class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftCandy = new int[n];
        int[] rightCandy = new int[n];

        leftCandy[0] = 1;
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]) leftCandy[i] = leftCandy[i-1] +1;
            else leftCandy[i] = 1;
        }
        int candy = 0;

        rightCandy[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]) rightCandy[i] = rightCandy[i+1] +1;
            else rightCandy[i] = 1;
        }

        for(int i=0; i<n; i++){
            candy += Math.max(leftCandy[i],rightCandy[i]);
        }
        return candy;
    }
}