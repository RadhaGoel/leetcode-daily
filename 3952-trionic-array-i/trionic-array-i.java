class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n < 3) return false; //should be 3 elements
        
        int i = 0; // pointer

        //strictly increasing
        while( i < n-1 && nums[i] < nums[i + 1]){
            i++;
        }
        int p = i;
        if(p == 0 || p == n - 1) //if p is first or last element
            return false;

        //strictly decreasing
        while( i < n-1 && nums[i] > nums[i+1]){
            i++;
        }
        int q = i;
        if(q == p || q == n - 1) //if p and q are the same or q is the last element
            return false;

        //strictly increasing again
        while(i < n-1 && nums[i] < nums[i+1]){
            i++;
        }

        return i == n -1; //last element should be i
    }
}