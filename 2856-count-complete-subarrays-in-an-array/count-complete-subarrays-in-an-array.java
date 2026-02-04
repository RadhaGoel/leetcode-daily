class Solution {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        //Count total distinct elements
        int totalDistinct = countDistinctElements(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;

        //Sliding window
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            //When window is complete
            while (map.size() == totalDistinct) {
                ans += (n - right);

                //Shrink window
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
