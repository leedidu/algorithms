import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력이 많음

        // 상근이가 가지고 있는 숫자카드 개수 N
        int N = Integer.parseInt(br.readLine()); // 오류날 땐 throws IOException
        Set<Integer> card = new HashSet<Integer>();

        // 숫자카드 N개 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        // 확인해야할 숫자카드 개수 M
        int M = Integer.parseInt(br.readLine());

        // M개 입력 받고 결과 출력
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (card.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
