class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }

        int[] partner = new int[n];
        for (int[] pair : pairs) {
            partner[pair[0]] = pair[1];
            partner[pair[1]] = pair[0];
        }

        int count = 0;
        for (int x = 0; x < n; x++) {
            int y = partner[x];

            for (int u : preferences[x]) {
                if (u == y) break;
                int v = partner[u];
                if (rank[u][x] < rank[u][v]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}