class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> result = new ArrayList<>();
        
        for (int num : nums) {
            long current = num;
            while (!result.isEmpty() && result.get(result.size() - 1) == current) {
                result.remove(result.size() - 1);
                current += current;
            }
            result.add(current);
        }        
        return result;
    }
}
