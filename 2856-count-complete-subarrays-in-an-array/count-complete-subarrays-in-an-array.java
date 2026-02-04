import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // 1️⃣ Count total distinct elements
        int totalDistinct = countDistinctElements(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;

        // 2️⃣ Sliding window
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // 3️⃣ When window is complete
            while (map.size() == totalDistinct) {
                ans += (n - right);

                // shrink window
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }

        return ans;
    }

    private int countDistinctElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        return set.size();
    }
}
