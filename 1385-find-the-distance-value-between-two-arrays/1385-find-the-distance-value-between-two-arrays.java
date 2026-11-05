class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;
        for (int a1 : arr1) {
            boolean condition = true;
            for (int a2 : arr2) {
                if (Math.abs(a1-a2) <= d) condition = false;
            }
            if (condition == true) distance++;           
        }
        return distance;
    }
}