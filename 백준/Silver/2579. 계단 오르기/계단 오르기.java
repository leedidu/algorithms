import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        score = new int[n + 1];

        if(n == 1){
            System.out.println(arr[1]);
        } else if(n == 2){
            System.out.println(arr[1] + arr[2]);
        } else if(n == 3){
            System.out.println(Math.max(arr[1] + arr[3], arr[2] + arr[3]));
        } else {
            score[1] = arr[1];
            score[2] = arr[1] + arr[2];
            score[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
            dp(arr);
            System.out.println(score[n]);
        }
    }

    public static void dp(int[] arr) {
        for (int i = 4; i < arr.length; i++) {
            score[i] = Math.max(score[i - 2] + arr[i], score[i - 3] + arr[i - 1] + arr[i]);
        }
    }
}