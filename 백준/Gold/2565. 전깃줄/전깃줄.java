import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] poles = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            poles[i][0] = Integer.parseInt(st.nextToken());
            poles[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(poles, Comparator.comparingInt(o -> o[0]));

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 0; i < n; i++) {
            int now = poles[i][1];
            for (int j = 0; j < i; j++) {
                if (poles[j][1] < now) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(n - max);
    }
}