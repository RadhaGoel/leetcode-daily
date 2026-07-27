class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums.length - 1;
        int y = nums.length - 2;
        return (nums[x] - 1) * (nums[y] - 1);
    }
}