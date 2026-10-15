class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sumOfSq = 0;

        for(int i = 0; i<n; i++){
            int[] freq = new int[101];
            int cnt = 0;

            for(int j = i; j<n; j++){
                int num = nums.get(j);
                freq[num]++;
                if(freq[num] == 1) cnt++;
                sumOfSq += cnt*cnt;
            }
        }
        return sumOfSq;
    }
}