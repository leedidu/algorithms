import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < st.length(); i++) {
            stack.push(st.charAt(i));

            boolean check = false;
            if (stack.size() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            answer.append(stack.get(i));
        }

        if(answer.length() == 0){
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }
    }
}