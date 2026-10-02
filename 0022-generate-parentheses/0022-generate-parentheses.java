class Solution {
    public void combinations(int n, int left, int right, String s, List<String> result){
        if (right==n){
            result.add(s);
            return ;
        }
        if (left<n) combinations(n, left+1, right, s+"(", result);
        if (right<left) combinations(n, left, right+1, s+")", result);
    }
    
    public List<String> generateParenthesis(int n) {       
        List<String> result= new ArrayList<>();
        combinations(n,0,0,"", result);
        return result;
    }


}