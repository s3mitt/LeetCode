class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        // Precompute minimum changes for every substring
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try all proper divisors
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;
                    int groups = len / d;

                    // Each residue group forms a palindrome
                    for (int r = 0; r < d; r++) {
                        int left = i + r;
                        int right = i + r + (groups - 1) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // DP: dp[i][parts] = minimum changes
        // for first i characters using parts substrings
        int INF = 1_000_000;

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int parts = 1; parts <= k; parts++) {

                // Last substring must have length >= 2
                for (int len = 2; len <= i; len++) {
                    int prev = i - len;

                    if (dp[prev][parts - 1] == INF) {
                        continue;
                    }

                    dp[i][parts] = Math.min(
                        dp[i][parts],
                        dp[prev][parts - 1] + cost[prev][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
