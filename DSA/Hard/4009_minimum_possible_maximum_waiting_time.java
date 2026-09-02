import java.util.*;

class Solution {
    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        Map<String, Integer> dp = new HashMap<>();
        dp.put("0,0,0,0", 0);

        int served = 0;

        for (int d : demand) {
            Map<String, Integer> next = new HashMap<>();

            for (Map.Entry<String, Integer> entry : dp.entrySet()) {
                String[] parts = entry.getKey().split(",");

                int used0 = Integer.parseInt(parts[0]);
                int used1 = Integer.parseInt(parts[1]);
                int busy0 = Integer.parseInt(parts[2]);
                int busy1 = Integer.parseInt(parts[3]);
                int maxWait = entry.getValue();

                if (fuel[0] - used0 >= d) {
                    int wait = busy0;
                    int newBusy0 = d;
                    int newBusy1 = Math.max(0, busy1 - busy0);

                    String key = (used0 + d) + "," + used1 + "," +
                            newBusy0 + "," + newBusy1;

                    next.merge(key, Math.max(maxWait, wait), Math::min);
                }

                if (fuel[1] - used1 >= d) {
                    int wait = busy1;
                    int newBusy0 = Math.max(0, busy0 - busy1);
                    int newBusy1 = d;

                    String key = used0 + "," + (used1 + d) + "," +
                            newBusy0 + "," + newBusy1;

                    next.merge(key, Math.max(maxWait, wait), Math::min);
                }
            }

            if (next.isEmpty()) break;

            dp = next;
            served++;
        }

        if (served == 0) return -1;

        int ans = Integer.MAX_VALUE;
        for (int x : dp.values()) ans = Math.min(ans, x);

        return ans;
    }
}