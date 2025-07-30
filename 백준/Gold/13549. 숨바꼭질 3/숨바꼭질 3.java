import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(n, k));
    }

    static int dijkstra(int n, int k) {
        int[] time = new int[100001]; // 현재 위치까지의 최소 시간
        Arrays.fill(time, Integer.MAX_VALUE);
        time[n] = 0;
        Queue<Integer> q = new PriorityQueue<>(); // 현재 위치
        q.offer(n);

        while (!q.isEmpty()) {
            int cur = q.poll(); // 위치
            int a = cur - 1; // 다음 위치
            int b = cur + 1;
            int c = 2 * cur;

            int curTime = time[cur];
            if (a >= 0 && a <= 100000 && time[a] > curTime + 1) {
                time[a] = curTime + 1;
                q.offer(a);
            }
            if (b >= 0 && b <= 100000 && time[b] > curTime + 1) {
                time[b] = curTime + 1;
                q.offer(b);
            }
            if (c >= 0 && c <= 100000 && time[c] > curTime) {
                time[c] = curTime;
                q.offer(c);
            }
        }
        return time[k];
    }
}

