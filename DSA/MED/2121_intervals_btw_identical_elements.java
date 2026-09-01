class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];

        // count[value] = number of occurrences seen
        // sum[value] = sum of indices seen
        long[] count = new long[100001];
        long[] sum = new long[100001];

        // Left side contribution
        for (int i = 0; i < n; i++) {
            int value = arr[i];

            ans[i] += (long) i * count[value] - sum[value];

            count[value]++;
            sum[value] += i;
        }

        // Reset for right side
        count = new long[100001];
        sum = new long[100001];

        // Right side contribution
        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];

            ans[i] += sum[value] - (long) i * count[value];

            count[value]++;
            sum[value] += i;
        }

        return ans;
    }
}