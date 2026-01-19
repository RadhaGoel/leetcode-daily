class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1_000_000_007;

        long kadane = 0, maxKadane = 0;
        long prefix = 0, maxPrefix = 0;
        long suffix = 0, maxSuffix = 0;
        long totalSum = 0;

        // Kadane + prefix
        for (int x : arr) {
            kadane = Math.max(x, kadane + x);
            maxKadane = Math.max(maxKadane, kadane);

            prefix += x;
            maxPrefix = Math.max(maxPrefix, prefix);

            totalSum += x;
        }

        // suffix
        for (int i = arr.length - 1; i >= 0; i--) {
            suffix += arr[i];
            maxSuffix = Math.max(maxSuffix, suffix);
        }

        if (k == 1) {
            return (int)(maxKadane % MOD);
        }

        if (totalSum > 0) {
            long result = maxSuffix + (k - 2) * totalSum + maxPrefix;
            return (int)(result % MOD);
        } else {
            // Only need two concatenations
            long curr = 0, best = 0;
            for (int i = 0; i < 2; i++) {
                for (int x : arr) {
                    curr = Math.max(x, curr + x);
                    best = Math.max(best, curr);
                }
            }
            return (int)(best % MOD);
        }
    }
}
