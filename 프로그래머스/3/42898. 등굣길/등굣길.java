import java.util.Arrays;


class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        int mod = 1000000007;

        for(int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 위쪽 또는 왼쪽이 -1이면 현재 위치의 계산을 하지 않고 넘어감
                if(map[i][j] == -1) {
//                    map[i][j] = 0;
                    continue;
                }

                if(map[i-1][j] > 0){
                    map[i][j] += map[i-1][j];
                }

                if(map[i][j-1] > 0){
                    map[i][j] += map[i][j-1];
                }
                    map[i][j] %= mod;
            }
        }

        return map[n][m];
    }
}