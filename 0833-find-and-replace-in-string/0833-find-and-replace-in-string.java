class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int k = indices.length;
        
        // match[i] stores the index of the operation if a valid match starts at index i in s
        int[] match = new int[n];
        Arrays.fill(match, -1);
        
        // Step 1: Validate matches against the original string s
        for (int i = 0; i < k; i++) {
            int idx = indices[i];
            String src = sources[i];
            
            if (s.startsWith(src, idx)) {
                match[idx] = i;
            }
        }
        
        // Step 2: Build the resulting string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < n) {
            if (match[i] != -1) {
                int opIndex = match[i];
                sb.append(targets[opIndex]);
                i += sources[opIndex].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }       
        return sb.toString();
    }
}