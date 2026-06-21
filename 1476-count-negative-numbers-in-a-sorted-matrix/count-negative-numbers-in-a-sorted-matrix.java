class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i[] : grid){
            for(int x : i){
                if(x < 0){
                    count++;
                }
            }
        }
        return count;
    }
}