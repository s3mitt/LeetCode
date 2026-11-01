class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        long[] p = new long[tasks.length];
        long s = 0;
        for (int i = 0; i < tasks.length; i++) {
            s += tasks[i];
            p[i] = s;
        }
        long d = 0;
        int[] res = new int[shifts.length];
        int n = tasks.length;
        for (int i = 0; i < shifts.length; i++) {
            if (d + shifts[i] >= s) {
                res[i] = 0;
                d = 0;
            } else {
                d += shifts[i];
                int left = 0, right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (p[mid] <= d) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res[i] = n - left;
            }
        }
        return res;
    }
}