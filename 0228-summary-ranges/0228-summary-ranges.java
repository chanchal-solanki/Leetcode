class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        int i = 0;
        
        while(i<n){
            int start = nums[i];

            while(i+1<n && nums[i+1] == nums[i]+1) i++;

            int end = nums[i];

            if(start == end) ans.add("" + start);
            else ans.add(start + "->" + end);
            i++;
        }
        return ans;
    }
}