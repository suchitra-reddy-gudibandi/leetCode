class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int answer = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {
            int distance = Math.abs(drones[i][0] - target[0])
                         + Math.abs(drones[i][1] - target[1]);

            // Check if the drone can reach the target
            if (distance <= drones[i][2] && distance < minDistance) {
                minDistance = distance;
                answer = i;
            }
        }

        return answer;
    }
}