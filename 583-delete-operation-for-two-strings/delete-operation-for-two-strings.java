class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];


        //BASE CASE
        for(int i = 1; i < m+1; i++){
            dp[i][0] = i;//delete all charactrs from s1
        }
        for(int j = 1; j < n+1; j++){
            dp[0][j] = j;//delete all from s2
        }

        //filling dp
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    //1 getting deleted -> if not matched-> so one added
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}