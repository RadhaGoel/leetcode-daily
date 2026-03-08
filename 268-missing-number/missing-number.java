// class Solution {
//     public int missingNumber(int[] nums) {
//         int xor = nums.length;

//         for(int i = 0; i < nums.length; i++){
//             xor ^= i ^ nums[i];
//         }

//         return xor;
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        return expected - sum;
    }
}