import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] w;
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        w = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            dfs(visited, i, 0, 0, i);
        }
        System.out.println(min);
    }

    public static void dfs(boolean[] visited, int now, int count, int cost, int start) {
        if (count == n - 1 && w[now][start] != 0) {
            if (w[now][start] != 0) {
                min = Math.min(min, cost + w[now][start]);
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && w[now][i] != 0) {
                    visited[i] = true;
                    dfs(visited, i, count + 1, cost + w[now][i], start);
                    visited[i] = false;
                }
            }
        }
    }
}