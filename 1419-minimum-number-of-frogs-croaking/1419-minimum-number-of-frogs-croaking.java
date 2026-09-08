class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0;
        int active = 0;
        int maxFrogs = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
                active++;
                maxFrogs = Math.max(maxFrogs, active);
            } 
            else if (ch == 'r') {
                if (c == 0) return -1;
                c--;
                r++;
            } 
            else if (ch == 'o') {
                if (r == 0) return -1;
                r--;
                o++;
            } 
            else if (ch == 'a') {
                if (o == 0) return -1;
                o--;
                a++;
            } 
            else if (ch == 'k') {
                if (a == 0) return -1;
                a--;
                active--;
            }
        }
        return active == 0 ? maxFrogs : -1;
    }
}