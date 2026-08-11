class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m= grid.size();
        int n=grid.get(0).size();

        int[][] best = new int[m][n];

        for(int[] row:best)
            Arrays.fill(row,-1);
        Queue<int[]> q= new LinkedList<>();

        int startHealth = health - grid.get(0).get(0);
        q.offer(new int[]{0,0,startHealth});
        best[0][0]=startHealth;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if(r == m-1 && c == n-1)
                return h>0;
            
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nr>=m || nc<0 || nc>=n)
                    continue;
                
                int nh=h-grid.get(nr).get(nc);

                if(nh>0 && nh > best[nr][nc]){
                    best[nr][nc] =nh;
                    q.offer(new int[]{nr,nc,nh});
                }
            }
        }
        return false;
    }
}