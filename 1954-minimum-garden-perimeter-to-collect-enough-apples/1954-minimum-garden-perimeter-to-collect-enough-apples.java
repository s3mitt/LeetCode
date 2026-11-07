class Solution {
    public long minimumPerimeter(long neededApples) {
        long apples = 0;
        long n = 0;
        while (apples < neededApples) {
            apples += 12*n*n;
            n++;
        }
        return (n-1)*8;
    }
}