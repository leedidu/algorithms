import java.util.*;

class Solution {
    static final int SIZE = 102; // 좌표 확장 크기
    static final int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static final int[] dy = {-1, 1, 0, 0};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] board = new boolean[SIZE][SIZE]; // 이동 가능 경로
        boolean[][] visited = new boolean[SIZE][SIZE]; // 방문 체크
        
        // 1. 경계선 설정
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            // 직사각형 전체 채우기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = true;
                }
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    board[x][y] = false;
                }
            }
        }

        // 2. BFS 탐색
        return bfs(board, visited, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    public static int bfs(boolean[][] board, boolean[][] visited, int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); //x, y, 이동 거리
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], distance = current[2];

            // 목표 지점 도달
            if (x == targetX && y == targetY) {
                return distance / 2; // 확장된거리 조정
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE
                        && board[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}
