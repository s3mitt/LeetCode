class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int prev = -1;
                boolean increasing = true;

                for (int i = 0; i < n; i++) {
                    if (i >= left && i <= right) continue;
                    if (prev != -1 && nums[i] <= prev) {
                        increasing = false;
                        break;
                    }
                    prev = nums[i];
                }
                if (increasing) count++;
            }
        }
        return count;
    }
}