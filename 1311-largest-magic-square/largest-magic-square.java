class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 2][n + 2];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j + 1] = diag2[i][j + 2] + grid[i][j];
            }
        }

        int ans = 1;

        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i + 1][j + size] - row[i + 1][j];

                    boolean ok = true;

                    // rows
                    for (int r = 0; r < size && ok; r++) {
                        int sum = row[i + r + 1][j + size] - row[i + r + 1][j];
                        if (sum != target) ok = false;
                    }

                    // columns
                    for (int c = 0; c < size && ok; c++) {
                        int sum = col[i + size][j + c + 1] - col[i][j + c + 1];
                        if (sum != target) ok = false;
                    }

                    // diagonals
                    int d1 = diag1[i + size][j + size] - diag1[i][j];
                    int d2 = diag2[i + size][j + 1] - diag2[i][j + size + 1];

                    if (ok && d1 == target && d2 == target) {
                        ans = size;
                    }
                }
            }
        }

        return ans;
    }
}
