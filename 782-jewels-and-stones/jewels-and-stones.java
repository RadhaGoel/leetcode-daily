class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
    
        for(char s : stones.toCharArray()){
            for(char j : jewels.toCharArray()){
                if(j == s){
                    count++;
                }
            }
        }
        return count;
    }
}