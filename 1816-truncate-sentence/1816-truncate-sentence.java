class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        return String.join(" ", Arrays.copyOfRange(words, 0, k));
    }
}