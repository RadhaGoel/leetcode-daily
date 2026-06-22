class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int ans = 1;
        int cur = 1;
        for(int i = 1; i <nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == (nums[i-1] + 1)){
                cur++;
            }
            else{
                ans = Math.max(ans, cur);
                cur = 1;
            }
        }
        ans = Math.max(ans, cur);
        return ans;
    }
}