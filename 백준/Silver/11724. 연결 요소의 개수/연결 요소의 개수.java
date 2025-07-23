import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        List<Integer>[] arr = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(visited, arr, i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(boolean[] visited, List<Integer>[] arr, int now){
        if(visited[now]) {
            return;
        } else {
            for(int a : arr[now]){
                visited[now] = true;
                dfs(visited, arr, a);
            }
        }
    }
}