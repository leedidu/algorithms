import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        int col = 0;
        int row = 0;
        int num = 1;
        
        queue.offer(new int[]{row, col, num});
        visited[0][0]=true;
        
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();            
            
            if (now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
                return now[2];
            }
            
            
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                
                if (nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length) {
                    if(maps[nr][nc]==1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr,nc,now[2]+1});
                    }
                }
            }
        }
        return -1;
    }
}