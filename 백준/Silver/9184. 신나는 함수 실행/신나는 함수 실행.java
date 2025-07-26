import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            } else {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + recursion(a, b, c));
            }
        }
    }

    public static int recursion(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return recursion(20, 20, 20);
        }
        if (a < b && b < c) {
            if (dp[a][b][c] == 0) {
                dp[a][b][c] = recursion(a, b, c - 1) + recursion(a, b - 1, c - 1) - recursion(a, b - 1, c);
            }
            return dp[a][b][c];
        } else {
            if (dp[a][b][c] == 0) {
                dp[a][b][c] = recursion(a - 1, b, c) + recursion(a - 1, b - 1, c) + recursion(a - 1, b, c - 1) - recursion(a - 1, b - 1, c - 1);
            }
            return dp[a][b][c];
        }
    }
}