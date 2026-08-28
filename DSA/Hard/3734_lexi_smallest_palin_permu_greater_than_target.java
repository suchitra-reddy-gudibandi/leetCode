class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) return "";

        int h = n / 2;
        int[] cnt = new int[26];

        for (int i = 0; i < 26; i++) {
            cnt[i] = freq[i] / 2;
        }

        char[] targetHalf = target.substring(0, h).toCharArray();

        int[] rem = cnt.clone();
        int matched = 0;

        while (matched < h && rem[targetHalf[matched] - 'a'] > 0) {
            rem[targetHalf[matched] - 'a']--;
            matched++;
        }

        if (matched == h) {
            String candidate = makePalindrome(targetHalf, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }

            int[] suffix = new int[26];

            for (int i = h - 1; i >= 0; i--) {
                suffix[targetHalf[i] - 'a']++;

                for (int c = targetHalf[i] - 'a' + 1; c < 26; c++) {
                    if (suffix[c] > 0) {
                        suffix[c]--;

                        char[] half = new char[h];

                        for (int j = 0; j < i; j++) {
                            half[j] = targetHalf[j];
                        }

                        half[i] = (char) ('a' + c);

                        int pos = i + 1;

                        for (int x = 0; x < 26; x++) {
                            while (suffix[x] > 0) {
                                half[pos++] = (char) ('a' + x);
                                suffix[x]--;
                            }
                        }

                        return makePalindrome(half, middle, n);
                    }
                }
            }

            return "";
        }

        rem = cnt.clone();

        for (int i = 0; i < matched; i++) {
            rem[targetHalf[i] - 'a']--;
        }

        for (int i = matched; i >= 0; i--) {
            if (i < matched) {
                rem[targetHalf[i] - 'a']++;
            }

            if (i >= h) continue;

            int start = targetHalf[i] - 'a' + 1;

            for (int c = start; c < 26; c++) {
                if (rem[c] > 0) {
                    rem[c]--;

                    char[] half = new char[h];

                    for (int j = 0; j < i; j++) {
                        half[j] = targetHalf[j];
                    }

                    half[i] = (char) ('a' + c);

                    int pos = i + 1;

                    for (int x = 0; x < 26; x++) {
                        while (rem[x] > 0) {
                            half[pos++] = (char) ('a' + x);
                            rem[x]--;
                        }
                    }

                    return makePalindrome(half, middle, n);
                }
            }
        }

        return "";
    }

    private String makePalindrome(char[] half, int middle, int n) {
        StringBuilder sb = new StringBuilder(n);

        for (char c : half) {
            sb.append(c);
        }

        if ((n & 1) == 1) {
            sb.append((char) ('a' + middle));
        }

        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }

        return sb.toString();
    }
}