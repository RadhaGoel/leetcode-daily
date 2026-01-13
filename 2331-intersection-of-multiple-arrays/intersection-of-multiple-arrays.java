class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int[] arr : nums) {
            Set<Integer> seen = new HashSet<>();
            for (int num : arr) {
                if (seen.add(num)) {
                    freq.put(num, freq.getOrDefault(num, 0) + 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}