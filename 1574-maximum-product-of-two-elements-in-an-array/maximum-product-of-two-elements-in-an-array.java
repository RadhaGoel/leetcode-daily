class Solution {
    public int maxProduct(int[] nums) {
        int bg = 0;
        int sb = 0;
        for(int num : nums){
            if(num > bg){
                sb = bg;
                bg = num;
            }
            else{
                sb = Math.max(sb, num);
            }
        }
        return (bg - 1) * (sb - 1);
    }
}