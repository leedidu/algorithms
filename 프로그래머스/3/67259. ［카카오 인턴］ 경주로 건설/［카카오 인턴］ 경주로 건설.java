import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 (x축 이동)
    static int[] dy = {0, 0, -1, 1}; // y축 이동
    static int[][][] cnt; // x, y, dir 저장

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        // 1 = 벽, 0 = 비워진 칸
        // 출발점 : 0,0 도착점 : n-1,n-1
        // 직선도로 = 100, 코너(직선도로가 직각으로 만나는 지점) = 500
        // 최단 경로를 찾아야함
        cnt = new int[board.length][board.length][4];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                for(int k = 0; k < 4; k++) {
                    cnt[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(0, 0, -1, board);

        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cnt[board.length - 1][board.length - 1][i]); // 최종 목적지에서의 최소 비용을 찾음
        }
        return answer;
    }

    public static void bfs(int x, int y, int dir, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, dir, 0}); // 위치와 방향 추가

        while(!q.isEmpty()){
            int[] p = q.poll();
            int pX = p[0];
            int pY = p[1];
            int pDir = p[2];
            int pCost = p[3];


            for(int i = 0; i < 4; i++){
                int newX = pX + dx[i];
                int newY = pY + dy[i];
                int newDir = i;
                int newCost = pCost;

                if(newX < 0 || newY < 0 || newX >= board.length || newY >= board.length || board[newX][newY] == 1){
                    continue;
                }
                if(pDir == -1) newCost += 100;
                else{
                    if(pDir == newDir){
                        newCost += 100;
                    } else{
                        newCost += 600;
                    }
                }

                if(cnt[newX][newY][newDir] > newCost){ // 더 적은 가격으로 갱신가능
                    cnt[newX][newY][newDir] = newCost;
                    q.add(new int[]{newX, newY, newDir, newCost});
                }
            }
        }
    }
}