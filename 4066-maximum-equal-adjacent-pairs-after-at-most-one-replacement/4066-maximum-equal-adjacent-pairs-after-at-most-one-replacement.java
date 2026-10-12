class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int alreadyEqual = 0;
        int maxGain = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a == b) {
                alreadyEqual++;
            }
            
            else {
                int smaller = Math.min(a, b);
                int larger = Math.max(a, b);

                String key = smaller + "," + larger;

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                maxGain = Math.max(maxGain, count);
            }
        }
        return alreadyEqual + maxGain;
    }
}
