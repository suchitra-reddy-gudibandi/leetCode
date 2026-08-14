class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        java.util.Arrays.fill(ans, -1);

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i];
            }
            return ans;
        }

        int window = 2 * k + 1;

        if (window > n) {
            return ans;
        }

        long sum = 0;

        for (int i = 0; i < window; i++) {
            sum += nums[i];
        }

        for (int i = k; i < n - k; i++) {
            ans[i] = (int)(sum / window);

            if (i + k + 1 < n) {
                sum += nums[i + k + 1];
                sum -= nums[i - k];
            }
        }

        return ans;
    }
}