import java.util.*;

class Solution {
    static class Robot {
        int x1, y1, x2, y2, time;

        public Robot(int x1, int y1, int x2, int y2, int time) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][][] visited = new boolean[n][n][n][n]; // 4차원 방문 체크
        Queue<Robot> queue = new LinkedList<>();

        queue.offer(new Robot(0, 0, 0, 1, 0)); // 시작 상태
        visited[0][0][0][1] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 이동 방향

        while (!queue.isEmpty()) {
            Robot curr = queue.poll();

            // 목표 도달 확인
            if ((curr.x1 == n - 1 && curr.y1 == n - 1) || (curr.x2 == n - 1 && curr.y2 == n - 1)) {
                return curr.time;
            }

            // 이동
            for (int[] dir : directions) {
                int nx1 = curr.x1 + dir[0];
                int ny1 = curr.y1 + dir[1];
                int nx2 = curr.x2 + dir[0];
                int ny2 = curr.y2 + dir[1];

                if (isValid(nx1, ny1, nx2, ny2, board, n) && !visited[nx1][ny1][nx2][ny2]) {
                    queue.offer(new Robot(nx1, ny1, nx2, ny2, curr.time + 1));
                    visited[nx1][ny1][nx2][ny2] = true;
                }
            }

            // 회전
            rotate(queue, curr, board, visited, n);
        }

        return 0; // 도달 불가
    }

    private void rotate(Queue<Robot> queue, Robot curr, int[][] board, boolean[][][][] visited, int n) {
        if (curr.x1 == curr.x2) { // 가로 → 세로
            if (curr.x1 > 0 && board[curr.x1 - 1][curr.y1] == 0 && board[curr.x2 - 1][curr.y2] == 0) {
                if (!visited[curr.x1 - 1][curr.y1][curr.x1][curr.y1]) {
                    queue.offer(new Robot(curr.x1 - 1, curr.y1, curr.x1, curr.y1, curr.time + 1));
                    visited[curr.x1 - 1][curr.y1][curr.x1][curr.y1] = true;
                }
                if (!visited[curr.x2 - 1][curr.y2][curr.x2][curr.y2]) {
                    queue.offer(new Robot(curr.x2 - 1, curr.y2, curr.x2, curr.y2, curr.time + 1));
                    visited[curr.x2 - 1][curr.y2][curr.x2][curr.y2] = true;
                }
            }
            if (curr.x1 < n - 1 && board[curr.x1 + 1][curr.y1] == 0 && board[curr.x2 + 1][curr.y2] == 0) {
                if (!visited[curr.x1][curr.y1][curr.x1 + 1][curr.y1]) {
                    queue.offer(new Robot(curr.x1, curr.y1, curr.x1 + 1, curr.y1, curr.time + 1));
                    visited[curr.x1][curr.y1][curr.x1 + 1][curr.y1] = true;
                }
                if (!visited[curr.x2][curr.y2][curr.x2 + 1][curr.y2]) {
                    queue.offer(new Robot(curr.x2, curr.y2, curr.x2 + 1, curr.y2, curr.time + 1));
                    visited[curr.x2][curr.y2][curr.x2 + 1][curr.y2] = true;
                }
            }
        } else { // 세로 → 가로
            if (curr.y1 > 0 && board[curr.x1][curr.y1 - 1] == 0 && board[curr.x2][curr.y2 - 1] == 0) {
                if (!visited[curr.x1][curr.y1 - 1][curr.x1][curr.y1]) {
                    queue.offer(new Robot(curr.x1, curr.y1 - 1, curr.x1, curr.y1, curr.time + 1));
                    visited[curr.x1][curr.y1 - 1][curr.x1][curr.y1] = true;
                }
                if (!visited[curr.x2][curr.y2 - 1][curr.x2][curr.y2]) {
                    queue.offer(new Robot(curr.x2, curr.y2 - 1, curr.x2, curr.y2, curr.time + 1));
                    visited[curr.x2][curr.y2 - 1][curr.x2][curr.y2] = true;
                }
            }
            if (curr.y1 < n - 1 && board[curr.x1][curr.y1 + 1] == 0 && board[curr.x2][curr.y2 + 1] == 0) {
                if (!visited[curr.x1][curr.y1][curr.x1][curr.y1 + 1]) {
                    queue.offer(new Robot(curr.x1, curr.y1, curr.x1, curr.y1 + 1, curr.time + 1));
                    visited[curr.x1][curr.y1][curr.x1][curr.y1 + 1] = true;
                }
                if (!visited[curr.x2][curr.y2][curr.x2][curr.y2 + 1]) {
                    queue.offer(new Robot(curr.x2, curr.y2, curr.x2, curr.y2 + 1, curr.time + 1));
                    visited[curr.x2][curr.y2][curr.x2][curr.y2 + 1] = true;
                }
            }
        }
    }

    private boolean isValid(int x1, int y1, int x2, int y2, int[][] board, int n) {
        return x1 >= 0 && x1 < n && y1 >= 0 && y1 < n &&
               x2 >= 0 && x2 < n && y2 >= 0 && y2 < n &&
               board[x1][y1] == 0 && board[x2][y2] == 0;
    }
}
