import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(a);

        while(true){
            int prev = list.get(list.size() - 1);
            int next = 0;
            int temp = prev;

            while(temp > 0) {
                int digit = temp % 10;
                temp /= 10;
                next += (int) Math.pow(digit, p);
            }


            if(list.contains(next)) {
                System.out.println(list.indexOf(next));
                break;
            }
            list.add(next);

        }
    }
}
