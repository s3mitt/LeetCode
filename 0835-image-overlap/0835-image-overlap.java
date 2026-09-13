class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
        int[][] count = new int[2 * n - 1][2 * n - 1];
        int maxOverlap = 0;
        
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                if (img1[i1][j1] == 0) continue;
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (img2[i2][j2] == 0) continue;
                        int dx = i2 - i1 + (n - 1);
                        int dy = j2 - j1 + (n - 1);
                        count[dx][dy]++;
                        maxOverlap = Math.max(maxOverlap, count[dx][dy]);
                    }
                }
            }
        }        
        return maxOverlap;
    }
}