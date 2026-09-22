class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int m = arr.length;
        int[][] dp = new int[m][m];

        for (int len = 2; len < m; len++) {
            for (int i = 0; i < m - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    int coins = arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j];
                    if (coins > dp[i][j]) {
                        dp[i][j] = coins;
                    }
                }
            }
        }
        return dp[0][m - 1];
    }
}