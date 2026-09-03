class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSum = 0; // Constraints state 0 <= grid[i][j], so sum is non-negative
        
        // Iterate through all possible top-left corners of a 3x3 hourglass
        for (int r = 0; r <= m - 3; r++) {
            for (int c = 0; c <= n - 3; c++) {
                // Calculate the current hourglass sum
                int currentSum = grid[r][c]   + grid[r][c+1]   + grid[r][c+2]   // Top row
                                              + grid[r+1][c+1]                  // Middle cell
                               + grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2]; // Bottom row
                
                // Track the maximum sum found
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}