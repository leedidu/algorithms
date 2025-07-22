import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int i = 0; i < T; i++){
            String ps = bf.readLine();
            solution(ps);
        }
    }

    public static void solution(String ps){
        Stack<String> stack = new Stack<>();
        String[] st = ps.split("");
        stack.push(st[0]);

        for(int i = 1; i < st.length; i++){
            String next = st[i];
            if(!stack.empty() && stack.peek().equals(next)){
                stack.push(next);
            } else {
                if(!stack.empty() && next.equals(")")){
                    stack.pop();
                } else {
                    stack.push(next);
                }
            }
        }

        if(stack.empty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
