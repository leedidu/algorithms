import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuffer tmp = new StringBuffer(); // 정답
        for(int i = 1; i < word.length() - 2; i++){
            for(int j = i + 1; j < word.length(); j++){
                StringBuffer tmp2 = new StringBuffer(); // 비교용
                StringBuffer a = new StringBuffer(word.substring(0, i)).reverse();
                StringBuffer b = new StringBuffer(word.substring(i, j)).reverse();
                StringBuffer c = new StringBuffer(word.substring(j)).reverse();

                tmp2.append(a);
                tmp2.append(b);
                tmp2.append(c);

                if(tmp.length() == 0 || tmp.compareTo(tmp2) > 0){
                    tmp = tmp2;
                }
            }
        }
        System.out.println(tmp);
    }
}
