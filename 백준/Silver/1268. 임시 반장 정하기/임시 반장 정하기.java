import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        // 이차원 행렬
        int[][] students = new int[num][5];
        for(int i = 0; i < num; i++){
            String tmp = sc.nextLine();
            String[] s = tmp.split(" ");
            for(int j = 0; j < 5; j++){
                students[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[] answer = new int[num];

        // 학년 별로 점수 매기기
        for (int i = 0; i < num; i++) { // 나
            for (int k = 0; k < num; k++) { // 비교 대상
                if (i == k) continue; // 나 자신은 제외
                for (int j = 0; j < 5; j++) { // 학년
                    if (students[i][j] == students[k][j]) {
                        answer[i]++;
                        break;
                    }
                }
            }
        }

        int max = answer[0];
        int maxIndex = 0;

        for(int i = 0; i < num; i++){
            if(max < answer[i]){
                max = answer[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex + 1);
    }
}
