class Solution {
    public int[][] specialGrid(int n) {
        if (n == 0) {
            return new int[][]{{0}};
        }

        int[][] small = specialGrid(n - 1);
        int m = small.length;
        int[][] ans = new int[2 * m][2 * m];

        int size = m * m;

        // Top-right: smallest values
        // Bottom-right: next values
        // Bottom-left: next values
        // Top-left: largest values

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j + m] = small[i][j];
                ans[i + m][j + m] = small[i][j] + size;
                ans[i + m][j] = small[i][j] + 2 * size;
                ans[i][j] = small[i][j] + 3 * size;
            }
        }

        return ans;
    }
}