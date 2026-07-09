class Solution {
    public int getMaxLen(int[] nums) {
        int ans = 0;
        int neg = 0;
        int pos = 0;

        for(int num : nums){
            if(num > 0){
                pos += 1;
                neg = (neg == 0) ? 0 : neg + 1;
            }
            else if(num < 0){
                int oldPos = pos;
                int oldNeg = neg;

                pos = (oldNeg == 0) ? 0 : oldNeg+1;
                neg = oldPos + 1;
            }
            else{
                pos = 0;
                neg = 0;
            }
            ans = Math.max(ans, pos);
        }
        return ans;
    }
}