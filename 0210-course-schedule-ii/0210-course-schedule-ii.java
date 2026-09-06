class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        int[] answer = new int[numCourses];
        int index = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            answer[index++] = curr;
            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    que.offer(neighbor);
                }
            }
        }
        if (index != numCourses) return new int[0];
        return answer;
    }
}