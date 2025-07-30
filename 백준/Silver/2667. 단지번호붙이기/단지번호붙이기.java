import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            String[] strs = str.split("");
            for (int j = 0; j < str.length(); j++) {
                map[i][j + 1] = Integer.parseInt(strs[j]);
            }
        }
        visited = new boolean[n + 2][n + 2];
        List<Integer> blockList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    blocks = 0;
                    dfs(i, j, visited, map);
                    blockList.add(blocks);
                }
            }
        }
        System.out.println(blockList.size());
        Collections.sort(blockList);
        for(int i = 0; i < blockList.size(); i++){
            System.out.println(blockList.get(i));
        }
    }

    static void dfs(int curCol, int curRow, boolean[][] visited, int[][] map) {
        visited[curCol][curRow] = true;
        blocks++;
        // 만약 붙어있는게 있다면 dfs
        if (map[curCol + 1][curRow] == 1 && !visited[curCol + 1][curRow]) {
            dfs(curCol + 1, curRow, visited, map);
        }
        if (map[curCol - 1][curRow] == 1 && !visited[curCol - 1][curRow]) {
            dfs(curCol - 1, curRow, visited, map);
        }
        if (map[curCol][curRow + 1] == 1 && !visited[curCol][curRow + 1]) {
            dfs(curCol, curRow + 1, visited, map);
        }
        if (map[curCol][curRow - 1] == 1 && !visited[curCol][curRow - 1]) {
            dfs(curCol, curRow - 1, visited, map);
        }
    }
}