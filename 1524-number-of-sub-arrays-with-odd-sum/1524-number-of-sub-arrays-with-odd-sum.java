class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int even = 1;
        int odd = 0;
        int sum = 0;

        int ans = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(sum % 2 == 0) {
                ans += odd;
                even++;
            }else{
                ans += even;
                odd++;
            }
            ans = ans % mod;
        }
        return ans;
    }
}