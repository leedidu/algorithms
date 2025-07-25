import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        System.out.println(bs(trees, m, max));
    }

    public static long bs(int[] trees, int m, int maxTree) {
        long left = 1;
        long right = maxTree;
        long max = 0;
        long mid;

        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }
            if (sum >= m) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}