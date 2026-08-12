class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int answer = 0;
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {

            int[] freq = new int[26];

            int left = 0;
            int right = 0;

            int unique = 0;
            int atLeastK = 0;

            while (right < n) {

                int index = s.charAt(right) - 'a';

                if (freq[index] == 0) {
                    unique++;
                }

                freq[index]++;

                if (freq[index] == k) {
                    atLeastK++;
                }

                right++;
                while (unique > targetUnique) {
                    int leftIndex = s.charAt(left) - 'a';

                    if (freq[leftIndex] == k) {
                        atLeastK--;
                    }

                    freq[leftIndex]--;

                    if (freq[leftIndex] == 0) {
                        unique--;
                    }

                    left++;
                }
                if (unique == targetUnique && unique == atLeastK) {
                    answer = Math.max(answer, right - left);
                }
            }
        }

        return answer;
    }
}