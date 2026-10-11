class Solution {
    public int minFlips(int[][] grid) {
        int rowFlips = 0, colFlips = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                if (grid[i][l] != grid[i][r]) rowFlips++;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int t = 0, b = m - 1; t < b; t++, b--) {
                if (grid[t][j] != grid[b][j]) colFlips++;
            }
        }
        return Math.min(rowFlips, colFlips);
    }
}