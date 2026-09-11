class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits)
            freq[d]++;

        int count = 0;

        for (int i = 1; i <= 9; i++) {       // Hundreds digit
            for (int j = 0; j <= 9; j++) {   // Tens digit
                for (int k = 0; k <= 8; k += 2) { // Even units digit

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
                        count++;
                }
            }
        }

        return count;
    }
}