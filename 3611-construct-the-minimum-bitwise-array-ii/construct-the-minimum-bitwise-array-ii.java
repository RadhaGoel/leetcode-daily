class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // Even numbers are impossible
            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing ones
            int t = 0;
            while (((x >> t) & 1) == 1) {
                t++;
            }

            // Flip the highest trailing 1
            ans[i] = x ^ (1 << (t - 1));
        }
        return ans;
    }
}
