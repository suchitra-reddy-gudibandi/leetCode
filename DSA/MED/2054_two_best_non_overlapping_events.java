import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // suffix[i] = maximum value from event i onward
        int[] suffix = new int[n];
        suffix[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int end = events[i][1];

            // Find first event with start > end
            int lo = i + 1, hi = n;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (events[mid][0] > end)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            // Attend only this event
            ans = Math.max(ans, events[i][2]);

            // Attend this + best compatible event
            if (lo < n)
                ans = Math.max(ans, events[i][2] + suffix[lo]);
        }

        return ans;
    }
}