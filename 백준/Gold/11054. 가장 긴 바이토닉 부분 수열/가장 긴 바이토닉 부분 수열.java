import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i번째 원소를 기준으로 증가/감소하는 부분 수열
        int[] increase = new int[n];
        int[] decrease = new int[n];

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        // 증가하는 부분 수열
        for (int i = 1; i < n; i++) { // 뒤의 수
            for (int j = 0; j < i; j++) { // i번째 수보다 앞에 있는 것
                if (arr[i] > arr[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

        // 감소하는 부분 수열
        for (int i = n - 1; i >= 0; i--) { // 뒤의 수
            for (int j = n - 1; j > i; j--) { // i번째 수보다 앞에 있는 것
                if (arr[i] > arr[j]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(decrease[i] + increase[i] - 1 > max){
                max = decrease[i] + increase[i] - 1;
            }
        }
        System.out.println(max);
    }
}