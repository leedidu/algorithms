import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[] counts = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        counts[2] = 1;
        counts[3] = 1;
        if (n > 3) {
            dp(n);
        }
        System.out.println(counts[n]);
    }

    public static void dp(int n) {
        for (int i = 4; i <= n; i++) {
            counts[i] = counts[i - 1] + 1;
            if (i % 3 == 0) {
                counts[i] = Math.min(counts[i / 3] + 1, counts[i]);
            } if (i % 2 == 0) {
                counts[i] = Math.min(counts[i / 2] + 1, counts[i]);
            } if(i % 2 != 0 && i % 3 != 0) {
                counts[i] = counts[i - 1] + 1;
            }
        }
    }
}
