class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
            
            // Early exit if we find 9 (maximum possible)
            if (maxDigit == 9) {
                return 9;
            }
        }

        return maxDigit;
    }
}