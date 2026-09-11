class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits)
            freq[d]++;

        int[] temp = new int[450];
        int size = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 8; k += 2) {

                    int[] used = new int[10];
                    used[i]++;
                    used[j]++;
                    used[k]++;

                    boolean possible = true;

                    for (int d = 0; d < 10; d++) {
                        if (used[d] > freq[d]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible)
                        temp[size++] = i * 100 + j * 10 + k;
                }
            }
        }

        int[] ans = new int[size];
        for (int i = 0; i < size; i++)
            ans[i] = temp[i];

        return ans;
    }
}