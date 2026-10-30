class Solution {
    public int minimumFlips(int n) {
        int hash[] = new int[32];
        int ans = 0, l = 0, r = 0;
        while(n > 0) {
            hash[r++] = n % 2;
            n /= 2;
        }
        while(l < r) {
            ans += (hash[l++] ^ hash[--r]);
        }
        return 2 * ans;
    }
}