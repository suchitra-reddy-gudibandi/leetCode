class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        long total=0;
        for(int[] row:grid){
            for(int val:row){
                total+=val;
            }
        }
        long sum=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                sum+= grid[i][j];
            }
            if(sum*2==total)
            return true;
        }
        sum=0;
        for(int j=0;j<n-1;j++){
            for(int i=0;i<m;i++){
                sum+=grid[i][j];
            }
            if(sum*2==total)
            return true;
        }
        return false;
    }
}