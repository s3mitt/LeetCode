class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        int INF = 1_000_000_000;
        int[][] dp = new int[d + 1][n + 1];

        for (int i = 0; i <= d; i++) {
            Arrays.fill(dp[i], INF);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, jobDifficulty[i - 1]);
            dp[1][i] = max;
        }

        for (int day = 2; day <= d; day++) {
            for (int i = day; i <= n; i++) {
                max = 0;
                for (int j = i; j >= day; j--) {
                    max = Math.max(max, jobDifficulty[j - 1]);
                    dp[day][i] = Math.min(dp[day][i], dp[day - 1][j - 1] + max);
                }
            }
        }
        return dp[d][n];
    }
}
