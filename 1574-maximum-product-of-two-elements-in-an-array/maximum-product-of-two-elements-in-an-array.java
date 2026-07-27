class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int n = nums.length;
        
        for(int i = 0; i <= n-1; i++){
            int ans = 0;
            for(int j = 0; j <= n-1; j++){
                if(i != j)
                    ans = (nums[i]-1) * (nums[j]-1);
                max = Math.max(max, ans);
            }
        }
        return max;
    }
}