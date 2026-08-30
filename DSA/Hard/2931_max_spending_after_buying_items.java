import java.util.*;

class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{values[i][n - 1], i, n - 1});
        }

        long ans = 0;
        long day = 1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            ans += (long) curr[0] * day;
            day++;

            int row = curr[1];
            int col = curr[2];

            if (col > 0) {
                pq.offer(new int[]{values[row][col - 1], row, col - 1});
            }
        }

        return ans;
    }
}