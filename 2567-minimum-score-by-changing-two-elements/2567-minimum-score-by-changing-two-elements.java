class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if(n == 3) return 0;

        Arrays.sort(nums);
        int s = Math.abs(nums[2]-nums[n-1]) ;
        int e = Math.abs(nums[n-2]-nums[1]);
        int se = Math.abs(nums[0]- nums[n-3]);
        return Math.min(s,Math.min(e,se));
    }
}