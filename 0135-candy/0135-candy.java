class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = n;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int up = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                up++;
                candies += up;
                i++;
            }

            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                candies += down;
                i++;
            }
            candies -= Math.min(up, down);
        }
        return candies;
    }
}