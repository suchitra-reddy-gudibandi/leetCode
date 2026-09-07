import java.util.*;

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        long[] dp = new long[s.length() + 1];
        dp[0] = 1; // Empty subsequence
        
        int[] last = new int[26];
        Arrays.fill(last, -1);
        
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            int idx = ch - 'a';
            
            dp[i] = (2 * dp[i - 1]) % MOD;
            
            // Remove duplicate subsequences
            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;
            }
            
            last[idx] = i;
        }
        
        // Remove the empty subsequence
        return (int)((dp[s.length()] - 1 + MOD) % MOD);
    }
}