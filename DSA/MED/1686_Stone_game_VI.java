class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) ->
            Integer.compare(
                bobValues[b] + aliceValues[b],
                bobValues[a] + aliceValues[a]
            )
        );

        int alice = 0;
        int bob = 0;

        for (int turn = 0; turn < n; turn++) {
            int i = indices[turn];

            if (turn % 2 == 0) {
                alice += aliceValues[i];
            } else {
                bob += bobValues[i];
            }
        }

        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        }

        return 0;
    }
}