class Solution {
    public int longestSubarray(int[] nums, int k) {
        int[] minaveloru = nums;
        int n = nums.length;
        int ans = 0;

        ans = Math.max(ans, longestDivisible(nums, k, -1));
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, longestDivisible(nums, k, i));
        }
        return ans;
    }

    private int longestDivisible(int[] nums, int k, int negatedIndex) {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);
        long sum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long value = nums[i];

            if (i == negatedIndex) value = -value;
            
            sum += value;
            int rem = (int) (sum % k);

            if (rem < 0) rem += k;
            if (first.containsKey(rem)) {
                ans = Math.max(ans, i - first.get(rem));
            } else {
                first.put(rem, i);
            }
        }
        return ans;
    }
}