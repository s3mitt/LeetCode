class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxCount = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c=='(') {
                stack.push(c);
                count++;
            }
            if (c==')') {
                maxCount = Math.max(maxCount, count);
                stack.pop();
                count--;
            }
        }
        return maxCount;
    }
}