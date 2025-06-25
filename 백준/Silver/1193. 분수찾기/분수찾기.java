import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();

        int numerator = solution(true, order);
        int denominator = solution(false, order);

        System.out.println(numerator + "/" + denominator);
    }

    public static int solution(boolean check, int order){ // true : 분자, false : 분모
        int num =  check ? 1 : 2; // 시작값 : 분자 1, 분모 2

        int tmp = 0;

        while (tmp < order) {
            tmp += (2 * num - 1);
            num += 2;
        }

        num -= 2; // 피크값 조절
        tmp -= (2 * num - 1); // 순서 조절

        if((order - tmp) < num){
            return order - tmp;
        } else {
            return 2 * num - (order - tmp);
        }
    }
}