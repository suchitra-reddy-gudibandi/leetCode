class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final int MOD = 1_000_000_007;

        long end0 = 0; // Good subsequences starting with 1 and ending in 0
        long end1 = 0; // Good subsequences starting with 1 and ending in 1
        boolean hasZero = false; // Whether "0" exists

        for (char c : binary.toCharArray()) {
            if (c == '0') {
                // Append 0 to subsequences that already start with 1
                end0 = (end0 + end1) % MOD;

                // "0" itself is a valid good subsequence
                hasZero = true;
            } else {
                // Append 1 to existing subsequences, or start new "1"
                end1 = (end0 + end1 + 1) % MOD;
            }
        }

        long answer = (end0 + end1 + (hasZero ? 1 : 0)) % MOD;

        return (int) answer;
    }
}