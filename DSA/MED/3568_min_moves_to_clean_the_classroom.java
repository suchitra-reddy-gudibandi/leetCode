import java.util.*;

public class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIdx[i], -1);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterIdx[i][j] = litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        
        boolean[][][][] visited = new boolean[m][n][1 << litterCount][energy + 1];
        
       
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        visited[startR][startC][0][energy] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int eng = curr[3];
            int moves = curr[4];
          
            if (mask == targetMask) {
                return moves;
            }
          
            if (eng == 0) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                
                int nextEng = eng - 1;
                char nextCell = classroom[nr].charAt(nc);
                
                if (nextCell == 'R') {
                    nextEng = energy;
                }
                
                int nextMask = mask;
                if (nextCell == 'L') {
                    nextMask |= (1 << litterIdx[nr][nc]);
                }
                
                if (!visited[nr][nc][nextMask][nextEng]) {
                    visited[nr][nc][nextMask][nextEng] = true;
                    queue.offer(new int[]{nr, nc, nextMask, nextEng, moves + 1});
                }
            }
        }
        
        return -1;
    }
}