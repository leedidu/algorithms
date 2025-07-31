import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 개수

            int[][] map = new int[m + 2][n + 2];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[col + 1][row + 1] = 1;
            }
            int worms = 0;
            boolean[][] visited = new boolean[m + 2][n + 2];
            for (int col = 0; col < m + 2; col++) {
                for (int row = 0; row < n + 2; row++) {
                    if (map[col][row] == 1 && !visited[col][row]) {
                        dfs(visited, col, row, map);
                        worms++;
                    }
                }
            }
            System.out.println(worms);
        }
    }

    static void dfs(boolean[][] visited, int startCol, int startRow, int[][] map) {
        if (visited[startCol][startRow]) {
            return;
        }

        visited[startCol][startRow] = true;

        if (map[startCol + 1][startRow] == 1) {
            dfs(visited, startCol + 1, startRow, map);
        }
        if (map[startCol - 1][startRow] == 1) {
            dfs(visited, startCol - 1, startRow, map);
        }
        if (map[startCol][startRow + 1] == 1) {
            dfs(visited, startCol, startRow + 1, map);
        }
        if (map[startCol][startRow - 1] == 1) {
            dfs(visited, startCol, startRow - 1, map);
        }
    }
}