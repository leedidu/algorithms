import java.util.*;
class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        Integer[] numbersSorted = new Integer[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            numbersSorted[i] = numbers[i];
        }

        Arrays.sort(numbersSorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1.toString() + o2.toString();
                String b = o2.toString() + o1.toString();
                return a.compareTo(b);
            }
        });

        for(int i = numbersSorted.length - 1; i >= 0; i--) {
            answer += numbersSorted[i];
        }

        if(answer.startsWith("0")){
            return "0";
        } else{
            return answer;

        }
        // 가장 큰수의 가장큰자릿수의 숫자비교해서 앞으로
    }
}