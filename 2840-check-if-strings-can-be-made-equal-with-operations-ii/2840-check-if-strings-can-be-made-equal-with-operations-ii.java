class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[][] count = new int[2][26];

        for (int i = 0; i < s1.length(); i++) {
            count[i % 2][s1.charAt(i) - 'a']++;
            count[i % 2][s2.charAt(i) - 'a']--;
        }

        for (int p = 0; p < 2; p++) {
            for (int c = 0; c < 26; c++) {
                if (count[p][c] != 0) return false;
            }
        }
        return true;
    }
}