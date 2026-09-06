class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int money : account) sum += money;
            max = Math.max(max, sum);
        }
        return max;
    }
}