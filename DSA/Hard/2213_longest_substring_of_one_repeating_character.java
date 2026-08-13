class Solution {
    int[] len, leftChar, rightChar, prefix, suffix, best;
    int size;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();

        size = 1;
        while (size < n) {
            size <<= 1;
        }

        int total = 2 * size;

        len = new int[total];
        leftChar = new int[total];
        rightChar = new int[total];
        prefix = new int[total];
        suffix = new int[total];
        best = new int[total];

        for (int i = 0; i < n; i++) {
            int p = size + i;
            int c = s.charAt(i) - 'a';

            len[p] = 1;
            leftChar[p] = c;
            rightChar[p] = c;
            prefix[p] = 1;
            suffix[p] = 1;
            best[p] = 1;
        }

        for (int p = size - 1; p >= 1; p--) {
            merge(p);
        }

        int k = queryCharacters.length();
        int[] ans = new int[k];

        for (int q = 0; q < k; q++) {
            int index = queryIndices[q];
            int c = queryCharacters.charAt(q) - 'a';

            int p = size + index;

            len[p] = 1;
            leftChar[p] = c;
            rightChar[p] = c;
            prefix[p] = 1;
            suffix[p] = 1;
            best[p] = 1;

            p >>= 1;

            while (p >= 1) {
                merge(p);
                p >>= 1;
            }

            ans[q] = best[1];
        }

        return ans;
    }

    private void merge(int p) {
        int left = p << 1;
        int right = left | 1;

        if (len[left] == 0) {
            len[p] = len[right];
            leftChar[p] = leftChar[right];
            rightChar[p] = rightChar[right];
            prefix[p] = prefix[right];
            suffix[p] = suffix[right];
            best[p] = best[right];
            return;
        }

        if (len[right] == 0) {
            len[p] = len[left];
            leftChar[p] = leftChar[left];
            rightChar[p] = rightChar[left];
            prefix[p] = prefix[left];
            suffix[p] = suffix[left];
            best[p] = best[left];
            return;
        }

        len[p] = len[left] + len[right];

        leftChar[p] = leftChar[left];
        rightChar[p] = rightChar[right];

        boolean same = rightChar[left] == leftChar[right];

        if (prefix[left] == len[left] && same) {
            prefix[p] = len[left] + prefix[right];
        } else {
            prefix[p] = prefix[left];
        }

        if (suffix[right] == len[right] && same) {
            suffix[p] = len[right] + suffix[left];
        } else {
            suffix[p] = suffix[right];
        }
        best[p] = Math.max(best[left], best[right]);

        if (same) {
            best[p] = Math.max(best[p], suffix[left] + prefix[right]);
        }
    }
}