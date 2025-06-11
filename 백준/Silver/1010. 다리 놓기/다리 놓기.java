import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < t; i++){
            String[] st = sc.nextLine().split(" ");
            int west = Integer.parseInt(st[0]);
            int east = Integer.parseInt(st[1]);
            System.out.println(answer(west,east));
        }
    }

    public static long answer(int n, int m) {
        long answer = 1;
        for (int i = 0; i < n; i++) {
            long numerator = m - i;
            long denominator = i + 1;

            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            answer /= denominator;
            answer *= numerator;
        }
        return answer;
    }

    public static long gcd(long a, long b) { // 최대공약수로 약분
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}