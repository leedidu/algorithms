import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    dfs(visited, arr, j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(boolean[] visited, int[] arr, int now){
        if(visited[now]) {
            return;
        } else {
            visited[now] = true;
            dfs(visited, arr, arr[now]);
        }
    }
}
