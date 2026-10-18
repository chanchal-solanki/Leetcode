class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        int s = 0;

        for(int i=0; i<n; i++){
            if(i+1<n && nums[i+1] != nums[i]+1){
                if(i-s == 0) ans.add(String.valueOf(nums[i]));
                else ans.add(String.valueOf(nums[s])+"->"+String.valueOf(nums[i]));
                s = i+1;
            }    
        }

         if(n-1-s == 0) ans.add(String.valueOf(nums[n-1]));
        else ans.add(String.valueOf(nums[s])+"->"+String.valueOf(nums[n-1]));
        return ans;
    }
}