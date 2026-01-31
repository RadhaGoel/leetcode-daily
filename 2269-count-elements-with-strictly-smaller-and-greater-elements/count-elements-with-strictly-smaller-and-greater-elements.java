class Solution {
    public int countElements(int[] nums) {
        int count = 0;
        for(int target : nums){
            if(smaller(target, nums) && greater(target, nums)){
                count++;
            }
        }
        return count;
    }
    private boolean smaller(int target, int nums[]){
        for(int i = 0; i < nums.length; i++){
            if(target < nums[i]){
                return true;
            }
        }
        return false;
    }
    private boolean greater(int target, int nums[]){
        for(int i = 0; i < nums.length; i++){
            if(target > nums[i]){
                return true;
            }
        }
        return false;
    }
}