import java.util.*;

class Solution {
    static boolean[][] visited;
    static int now;
    
    public int solution(int[][] land) {
        int answer = 0;
        visited = new boolean[land.length][land[0].length];
        int[] oil = new int[land[0].length];
        
        
        for(int j = 0; j < land.length; j++){
           for(int i = 0; i < land[0].length; i++){
                if(land[j][i] == 1 && !visited[j][i]){
                    now = 0;
                    Set<Integer> rows = new HashSet<>();
                    bfs(j, i, land, rows);
                    for (int c : rows) {
                        oil[c] += now;
                    }
                } 
            }
        }
        
        for(int i : oil){
            if(answer < i){
                answer = i;
            }
        }
        return answer;
    }
    
    private void bfs(int startRow, int startCol, int[][] land, Set<Integer> cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];

            now++;
            cols.add(col);

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length) {
                    if (!visited[nr][nc] && land[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

}