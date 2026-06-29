class NumMatrix {
int pf[][]; //prefix array

    public NumMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        pf = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                pf[i][j] = mat[i][j];
                if((i - 1) >= 0 ) pf[i][j] += pf[i-1][j];
                if((j-1) >= 0) pf[i][j] += pf[i][j-1];
                if((i-1) >=0 && (j-1) >= 0) pf[i][j] -= pf[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int ans = pf[r2][c2];
        if((c1 - 1) >= 0) ans -= pf[r2][c1-1];
        if((r1 - 1) >= 0) ans -= pf[r1-1][c2];
        if((r1 - 1) >= 0 && (c1 - 1) >= 0) ans += pf[r1-1][c1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */