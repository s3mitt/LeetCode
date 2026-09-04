class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : times) {
            adj.get(e[0] - 1).add(new int[]{e[1] - 1, e[2]});
        }
        k--;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int wt = cur[0], node = cur[1];
            if (wt > dist[node]) continue;

            for (int[] nb : adj.get(node)) {
                int nbr = nb[0], w = nb[1];
                if (wt + w < dist[nbr]) {
                    dist[nbr] = wt + w;
                    pq.offer(new int[]{dist[nbr], nbr});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}