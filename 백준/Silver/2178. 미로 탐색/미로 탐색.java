import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] miro = new int[n + 2][m + 2];

        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            String[] strings = s.split("");
            for (int j = 0; j < m; j++) {
                miro[i][j + 1] = Integer.parseInt(strings[j]);
            }
        }
        boolean[][] visited = new boolean[n + 2][m + 2];
        num = new int[n + 2][m + 2];
        num[1][1] = 1;
        bfs(visited, 1, 1, miro);
        System.out.println(num[n][m]);
    }

    static void bfs(boolean[][] visited, int col, int row, int[][] miro) {
        if (visited[col][row]) {
            return;
        }

        visited[col][row] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{col, row});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curCol = cur[0];
            int curRow = cur[1];

            if (miro[curCol + 1][curRow] == 1 && !visited[curCol + 1][curRow]) {
                q.offer(new int[]{curCol + 1, curRow});
                visited[curCol + 1][curRow] = true;
                num[curCol + 1][curRow] = num[curCol][curRow] + 1;
            }
            if (miro[curCol - 1][curRow] == 1 && !visited[curCol - 1][curRow]) {
                q.offer(new int[]{curCol - 1, curRow});
                visited[curCol - 1][curRow] = true;
                num[curCol - 1][curRow] = num[curCol][curRow] + 1;
            }
            if (miro[curCol][curRow + 1] == 1 && !visited[curCol][curRow + 1]) {
                q.offer(new int[]{curCol, curRow + 1});
                visited[curCol][curRow + 1] = true;
                num[curCol][curRow + 1] = num[curCol][curRow] + 1;
            }
            if (miro[curCol][curRow - 1] == 1 && !visited[curCol][curRow - 1]) {
                q.offer(new int[]{curCol, curRow - 1});
                visited[curCol][curRow - 1] = true;
                num[curCol][curRow - 1] = num[curCol][curRow] + 1;
            }
        }
    }
}