class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int[] used = new int[26];
        int bestPos = -1;
        int bestChar = -1;

        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (cnt[c] - used[c] > 0) {
                    bestPos = i;
                    bestChar = c;
                    break;
                }
            }

            if (cnt[t] - used[t] == 0) {
                break;
            }

            used[t]++;
        }

        if (bestPos == -1) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        int[] remaining = cnt.clone();

        for (int i = 0; i < bestPos; i++) {
            char c = target.charAt(i);
            ans.append(c);
            remaining[c - 'a']--;
        }

        ans.append((char) ('a' + bestChar));
        remaining[bestChar]--;

        for (int c = 0; c < 26; c++) {
            while (remaining[c] > 0) {
                ans.append((char) ('a' + c));
                remaining[c]--;
            }
        }

        return ans.toString();
    }
}