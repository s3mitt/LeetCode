class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];

        // Iterative DFS for ancestor tracking
        int[] stack = new int[2 * n + 1];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];

            if (node >= 0) {
                int ch = s.charAt(node) - 'a';

                previous[node] = last[ch];

                if (last[ch] != -1) {
                    newParent[node] = last[ch];
                }

                last[ch] = node;

                stack[top++] = ~node;

                for (int child : tree[node]) {
                    stack[top++] = child;
                }

            } else {
                node = ~node;
                int ch = s.charAt(node) - 'a';

                last[ch] = previous[node];
            }
        }

        // Build modified tree
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Initialize subtree sizes
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // Separate stack and traversal order
        int[] order = new int[n];
        int[] dfsStack = new int[n];

        int top2 = 0;
        int count = 0;

        dfsStack[top2++] = 0;

        while (top2 > 0) {
            int node = dfsStack[--top2];

            order[count++] = node;

            for (int child : newTree[node]) {
                dfsStack[top2++] = child;
            }
        }

        // Calculate subtree sizes bottom-up
        for (int i = count - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
