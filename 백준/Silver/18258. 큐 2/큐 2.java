import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        LinkedList<Integer> ans = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String[] part = bf.readLine().split(" ");
            String s = part[0];

            switch (s){
                case "push":
                    ans.add(Integer.parseInt(part[1]));
                    break;
                case "pop":
                    answer.append(!ans.isEmpty() ? ans.pop() : -1).append("\n");
                    break;
                case "size":
                    answer.append(ans.size()).append("\n");
                    break;
                case "empty":
                    answer.append(ans.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    answer.append(!ans.isEmpty() ? ans.peek() : -1).append("\n");
                    break;
                case "back":
                    answer.append(!ans.isEmpty() ? ans.peekLast() : -1).append("\n");
                    break;
            }
        }
        System.out.print(answer);
    }
}