class Solution {
    public int minMoves(int[] nums) {
        int sum =0 ;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            sum += num;
            max = Math.max(num,max);
        }

       return max * nums.length - sum;
    }
}