import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] 
                ? Integer.compare(a[0], b[0]) 
                : Integer.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long score = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int index = curr[1];

            if (marked[index]) continue;

            score += curr[0];

            marked[index] = true;

            if (index > 0)
                marked[index - 1] = true;

            if (index < n - 1)
                marked[index + 1] = true;
        }

        return score;
    }
}