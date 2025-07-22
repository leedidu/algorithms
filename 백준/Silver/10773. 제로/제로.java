import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++){
            int x = Integer.parseInt(bf.readLine());
            if(x == 0){
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        int ans = 0;
        while(!stack.empty()){
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}
