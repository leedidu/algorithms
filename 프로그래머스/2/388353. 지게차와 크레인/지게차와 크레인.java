import java.util.*;

class Solution {
    public static int solution(String[] storage, String[] requests) {
        int answer = 0;
        String[][] storages = new String[storage.length + 2][storage[0].length() + 2];
        for (int i = 0; i < storage.length; i++) { // 행
            String[] st = storage[i].split("");
            for (int j = 0; j < storage[i].length(); j++) {
                storages[i + 1][j + 1] = st[j];
            }
        }

        for (int i = 0; i < requests.length; i++) {
            int command = requests[i].length();
            boolean[][] check = new boolean[storage.length + 2][storage[0].length() + 2];

            for (int r = 0; r < check.length; r++) {
                for (int c = 0; c < check[0].length; c++) {
                    if (r == 0 || r == check.length - 1 || c == 0 || c == check[0].length - 1) {
                        check[r][c] = true;
                    }
                }
            }
            if (command == 1) { // 지게차
                for (int j = 0; j < storages.length; j++) {
                    for (int k = 0; k < storages[0].length; k++) {
                        if (storages[j][k] == null && !check[j][k]) {
                            bfs(check, 0, 0, storages);
                        }
                    }
                }

                for (int row = 1; row < storages.length - 1; row++) {
                    for (int col = 1; col < storages[row].length - 1; col++) {
                        if (storages[row][col] != null && storages[row][col].equals(requests[i])) {
                            if (check[row + 1][col] || check[row - 1][col] || check[row][col + 1] || check[row][col - 1]) {
                                storages[row][col] = null;
                            }
                        }
                    }
                }

                for (int row = 1; row < storages.length - 1; row++) {
                    for (int col = 1; col < storages[row].length - 1; col++) {
                        if (storages[row][col] == null && !check[row][col]) {
                            storages[row][col] = null;
                        }
                    }
                }
            } else { // 크레인
                String find = requests[i].split("")[0];
                for (int row = 1; row < storages.length - 1; row++) {
                    for (int col = 1; col < storages[row].length - 1; col++) {
                        if (storages[row][col] != null && storages[row][col].equals(find)) {
                            storages[row][col] = null;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < storages.length; i++) {
            for (int j = 0; j < storages[i].length; j++) {
                if (storages[i][j] != null) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void bfs(boolean[][] check, int r, int c, String[][] storages) {
        boolean[][] visited = new boolean[check.length][check[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 좌표 꺼냄
            r = now[0];
            c = now[1];
            check[r][c] = true;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (0 <= nr && nr < check.length && 0 <= nc && nc < check[0].length) {
                    if (!visited[nr][nc] && storages[nr][nc] == null) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}