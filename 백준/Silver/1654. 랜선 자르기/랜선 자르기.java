import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long max = 0;
        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if(lines[i] > max){
                max = lines[i];
            }
        }
        System.out.println(bs(lines, n, max));
    }

    public static long bs(int[] lines, int n, long max) {
        long left = 1; // 최소길이
        long right = max;
        long ans = 0;
        while (right - left >= 0) {
            long cnt = 0;
            long mid = (left + right) / 2; // 자를 길이
            for (int i = 0; i < lines.length; i++) {
                cnt += (lines[i] / mid);
            }
            if (cnt >= n) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}