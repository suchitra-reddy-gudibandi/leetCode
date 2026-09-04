class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            } else {
                if (i - first[ch] - 1 != distance[ch]) {
                    return false;
                }
            }
        }

        return true;
    }
}