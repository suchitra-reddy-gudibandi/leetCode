class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[2048];

        for (int x : nums) {
            present[x] = true;
        }

        boolean[] pair = new boolean[2048];

        for (int a = 1; a < 2048; a++) {
            if (!present[a]) continue;

            for (int b = 1; b < 2048; b++) {
                if (present[b]) {
                    pair[a ^ b] = true;
                }
            }
        }

        boolean[] result = new boolean[2048];

        for (int x = 1; x < 2048; x++) {
            if (!present[x]) continue;

            for (int p = 0; p < 2048; p++) {
                if (pair[p]) {
                    result[x ^ p] = true;
                }
            }
        }

        int count = 0;

        for (boolean x : result) {
            if (x) count++;
        }

        return count;
    }
}