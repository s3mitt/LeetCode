class Solution {
    public int minMoves(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                q.add(i - q.size());
            }
        }

        int n = q.size();
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + q.get(i);
        }

        long minMoves = Long.MAX_VALUE;
        int m = k / 2;

        for (int i = 0; i <= n - k; i++) {
            int midIndex = i + m;
            long medianVal = q.get(midIndex);

            long leftCount = m;
            long leftSum = prefixSum[midIndex] - prefixSum[i];
            long leftCost = leftCount * medianVal - leftSum;

            long rightCount = k - 1 - m;
            long rightSum = prefixSum[i + k] - prefixSum[midIndex + 1];
            long rightCost = rightSum - rightCount * medianVal;

            minMoves = Math.min(minMoves, leftCost + rightCost);
        }
        return (int) minMoves;
    }
}