class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and work backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;     // Just add 1 and return
                return digits;
            }
            digits[i] = 0;       // Set current digit to 0 and continue
        }

        // If all digits were 9, we need an extra digit at the beginning
        int[] result = new int[n + 1];
        result[0] = 1; // rest are already 0 by default
        return result;
    }
}
