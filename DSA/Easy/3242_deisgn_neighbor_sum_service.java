class NeighborSum {
    int[][] grid;
    int n;
    int[][] pos;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        pos = new int[n * n][2];

        // Store position of every value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }
    }

    public int adjacentSum(int value) {
        int r = pos[value][0];
        int c = pos[value][1];
        int sum = 0;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n)
                sum += grid[nr][nc];
        }

        return sum;
    }

    public int diagonalSum(int value) {
        int r = pos[value][0];
        int c = pos[value][1];
        int sum = 0;

        int[][] dir = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n)
                sum += grid[nr][nc];
        }

        return sum;
    }
}