class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // 2D prefix sum
        int[][] pref = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] =
                        pref[i][j + 1]
                      + pref[i + 1][j]
                      - pref[i][j]
                      + mat[i][j];
            }
        }

        int ans = 0;

        for (int size = 1; size <= Math.min(m, n); size++) {
            boolean found = false;

            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int sum =
                            pref[i + size][j + size]
                          - pref[i][j + size]
                          - pref[i + size][j]
                          + pref[i][j];

                    if (sum <= threshold) {
                        ans = size;
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }

        return ans;
    }
}
