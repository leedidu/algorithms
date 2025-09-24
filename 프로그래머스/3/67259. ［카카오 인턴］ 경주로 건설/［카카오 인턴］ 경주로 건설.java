import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        // 도착지 : n-1, n-1 
        // 직선도로 : 100, 코너 : 500
        int[] ans = dijkstra(board.length, board);
        Arrays.sort(ans);
        answer = ans[0];
        return answer;
    }
    
    public int[] dijkstra(int n, int[][] board){
        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = -1;
        dist[0][0][1] = -1;
        dist[0][0][2] = -1;
        dist[0][0][3] = -1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.offer(new int[]{0, 0, -1, 0});
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndir = i;
                if(nx < n && ny < n && nx >= 0 && ny >= 0){ // 범위 내
                    if(board[nx][ny] == 0){ // 갈 수 있는 곳
                        int newCost;
                        if (cur[2] == -1) {
                            newCost = cur[3] + 100;
                        } else if (cur[2] == ndir) {
                            newCost = cur[3] + 100;
                        } else { // 코너
                            newCost = cur[3] + 600;
                        }
                        if(dist[nx][ny][i] > newCost){
                            dist[nx][ny][i] = newCost;
                            pq.offer(new int[]{nx, ny, i, newCost});
                        }
                    }
                }
            }
        }
        return dist[n - 1][n - 1];
    }
}