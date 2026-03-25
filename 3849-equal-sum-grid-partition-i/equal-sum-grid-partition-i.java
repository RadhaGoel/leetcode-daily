class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;

        // Calculate total sum
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                total += grid[i][j];
            }
        }

        // If total is odd, cannot split equally
        if(total % 2 != 0) return false;

        long req = total / 2;

        // Check horizontal cuts
        long rowsum = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                rowsum += grid[i][j];
            }
            if(rowsum == req) return true;
        }

        // Check vertical cuts
        long colsum = 0;
        for(int j = 0; j < m - 1; j++){
            for(int i = 0; i < n; i++){
                colsum += grid[i][j];
            }
            if(colsum == req) return true;
        }

        return false;
    }
}