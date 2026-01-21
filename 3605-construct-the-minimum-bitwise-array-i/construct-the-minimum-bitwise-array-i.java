class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int num = find(nums.get(i));
            ans[i] = num; 
        }
        return ans;
    }
    private int find(int num){
        for(int i = 0;  i <= num; i++){
            if ((i | i + 1) == num) {
                return i;
        }
        }
        return -1;
    }
}