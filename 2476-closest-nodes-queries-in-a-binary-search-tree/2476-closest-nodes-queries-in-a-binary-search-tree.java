class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        inorder(root, nums);

        for (int q : queries) {
            int i = lowerBound(nums, q);
            int small;
            int large;

            if (i == nums.size()) {
                small = nums.get(i - 1);
                large = -1;
            } else if (nums.get(i) == q) {
                small = q;
                large = q;
            } else if (i == 0) {
                small = -1;
                large = nums.get(i);
            } else {
                small = nums.get(i - 1);
                large = nums.get(i);
            }
            ans.add(Arrays.asList(small, large));
        }
        return ans;
    }

    void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    int lowerBound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}