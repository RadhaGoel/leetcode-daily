class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int count = 0;
        // Count elements strictly between min and max
        for (int x : nums) {
            if (x > min && x < max) {
                count++;
            }
        }

        return count;
    }
}
