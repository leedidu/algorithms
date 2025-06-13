import java.util.Scanner;

public class Main {
    static int length = 64; // 기존 막대
    static int answer = 1;
    static int tmp = 64; // 현재 막대 길이 합
    static int x;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();

        numberOfSticks();
        System.out.println(answer);
    }

    public static void numberOfSticks(){
        while (tmp != x) {
            length /= 2; // 막대 길이를 절반으로 자름
            if (tmp > x) { // 만약 현재 길이가 크면 x 중 하나를 버림
                tmp -= length;
            } else {
                tmp += length;
                answer++;
            }
        }
    }
}
