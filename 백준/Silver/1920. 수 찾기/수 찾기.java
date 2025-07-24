import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        
        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++){
            System.out.println(binarySearch(a, Integer.parseInt(st.nextToken())));
        }
    }

    public static int binarySearch(int[] a, int num){
        int left = 0;
        int right = a.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(a[mid] == num) {
                return 1;
            } else if(a[mid] < num){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}