class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefix = new int[m + 1][n + 1];
        int[] values = new int[m * n];

        int index = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    ^ prefix[i - 1][j]
                    ^ prefix[i][j - 1]
                    ^ prefix[i - 1][j - 1];

                values[index++] = prefix[i][j];
            }
        }

        Arrays.sort(values);

        return values[values.length - k];
    }
}