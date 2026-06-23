class Solution {
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int nums[], int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        while(n > 0 && nums[n-1] >= nums[n])
            n--;
        if(n == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int n2 = nums.length - 1;
        while(n2 >= n && nums[n2] <= nums[n - 1])
            n2--;
        swap(nums, n - 1, n2);
        reverse(nums, n, nums.length - 1);
    }
}