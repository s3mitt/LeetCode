class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenSet = new HashSet<>(forbidden);        
        int maxLen = 0;
        int right = word.length() - 1;
        
        for (int left = word.length() - 1; left >= 0; left--) {
            for (int k = left; k <= Math.min(left + 9, right); k++) {                
                String sub = word.substring(left, k + 1);

                if (forbiddenSet.contains(sub)) {
                    right = k - 1;
                    break; 
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }       
        return maxLen;
    }
}