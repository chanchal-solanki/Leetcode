class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int i =0, j =0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int[] best = new int[n];
        Arrays.fill(best,Integer.MAX_VALUE);

        while(j<n){
            sum += arr[j];

            while( i<n && sum>target){
                sum -= arr[i];
                i++;
            }

            if(sum == target){ 
                int len = j-i+1;

                if(i>0 && best[i-1] != Integer.MAX_VALUE) {
                    res = Math.min(res,len+best[i-1]);
                }
                best[j] = len;
            }
            if(j>0) best[j] = Math.min(best[j-1],best[j]);
            j++;

        }
        return res == Integer.MAX_VALUE ? -1  : res;
    }
}