class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int x : cardPoints) {
            total += x;
        }

        if (k == n) {
            return total;
        }

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindow = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindow = Math.min(minWindow, windowSum);
        }

        return total - minWindow;
    }
}