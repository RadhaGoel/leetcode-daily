class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int operations = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            // find leftmost adjacent pair with minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            // replace the pair with their sum
            int merged = list.get(idx) + list.get(idx + 1);
            list.remove(idx);      // remove left
            list.remove(idx);      // remove right (same index after shift)
            list.add(idx, merged); // insert merged value

            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
