import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> open = Arrays.asList("(", "{", "[");
        List<String> close = Arrays.asList(")", "}", "]");

        while (true) {
            String line = bf.readLine();

            if (line.equals(".")) {
                break;
            }

            String[] st = line.split("");

            Stack<String> stack = new Stack<>();

            for(int i = 0; i < st.length; i++){
                String now = st[i];
                if(close.contains(now) || open.contains(now)){ // 괄호일 경우
                    if(stack.empty()){
                        stack.push(now);
                    } else {
                        if(open.contains(stack.peek()) && close.contains(now) && open.indexOf(stack.peek()) == close.indexOf(now)){
                            stack.pop();
                        } else {
                            stack.push(now);
                        }
                    }
                }
            }

            if(stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
