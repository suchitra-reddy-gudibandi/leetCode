class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int ans : answers) {
            counts.put(ans, counts.getOrDefault(ans, 0) + 1);
        }
        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int ans = entry.getKey();
            int reportedCount = entry.getValue();
            int groupSize = ans + 1;
            int numGroups = (reportedCount + groupSize - 1) / groupSize;
            totalRabbits += numGroups * groupSize;
        }
        return totalRabbits;
    }
}