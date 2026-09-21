class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        
        for (char c : a.toCharArray()) {
            cntA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            cntB[c - 'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        
        int prefixA = 0;
        int prefixB = 0;
        
        for (int i = 0; i < 25; i++) {
            prefixA += cntA[i];
            prefixB += cntB[i];
            
            int cost1 = (m - prefixA) + prefixB;
            int cost2 = (n - prefixB) + prefixA;           
            ans = Math.min(ans, Math.min(cost1, cost2));
        }
        
        for (int i = 0; i < 26; i++) {
            int cost3 = (m - cntA[i]) + (n - cntB[i]);
            ans = Math.min(ans, cost3);
        }       
        return ans;
    }
}