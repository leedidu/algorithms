import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        Stack<Integer> ans = new Stack<>();

        for(int i = 0; i < x; i++){
            String[] part = reader.readLine().split(" ");
            int num = Integer.parseInt(part[0]);

            switch (num){
                case 1:
                    ans.push(Integer.parseInt(part[1]));
                    break;
                case 2:
                    if(!ans.empty()){
                        System.out.println(ans.pop());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 3:
                    System.out.println(ans.size());
                    break;
                case 4:
                    if(ans.empty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case 5:
                    if(!ans.empty()){
                        System.out.println(ans.peek());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
