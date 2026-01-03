class Solution {
    public int numOfWays(int n) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[n + 1][2];

        dp[1][0] = 6; // ABC
        dp[1][1] = 6; // ABA

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (2 * dp[i - 1][0] + 2 * dp[i - 1][1]) % MOD;
            dp[i][1] = (2 * dp[i - 1][0] + 3 * dp[i - 1][1]) % MOD;
        }

        return (int)((dp[n][0] + dp[n][1]) % MOD);
    }
}
