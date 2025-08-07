import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 가능한 무게

        int[][] things = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken()); // 무게
            things[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[][] backpack = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) { // 물건
            for (int j = 1; j <= k; j++) { // 무게
                if (things[i][0] > j) { // 현재 가능한 무게를 초과한 경우
                    backpack[i][j] = backpack[i - 1][j];
                } else {
                    backpack[i][j] = Math.max(backpack[i - 1][j], backpack[i - 1][j - things[i][0]] + things[i][1]);
                }
            }
        }
        int[] total = backpack[n];
        int ans = 0;
        for (int i = 0; i < total.length; i++) {
            if(ans < total[i]){
                ans = total[i];
            }
        }
        System.out.println(ans);
    }
}