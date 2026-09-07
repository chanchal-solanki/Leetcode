class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();

        int[] last = new int[26];
        long[] dp = new long[n + 1];

        long MOD = 1000000007L;

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            dp[i + 1] = (2 * dp[i]) % MOD;

            if (last[idx] != 0) {
                dp[i + 1] =
                    (dp[i + 1] - dp[last[idx] - 1] + MOD) % MOD;
            }

            last[idx] = i + 1;
        }

        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}