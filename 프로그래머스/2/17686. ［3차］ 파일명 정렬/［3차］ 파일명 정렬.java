import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static String[] solution(String[] files) {
        String[] answer = {};
        // head 부분을 사전 순으로 정렬 (대소문자 구분X)
        // 대소문자 외에 같을 경우에는 number 순으로 정렬 (앞의 0은 무시 : 0012 == 12)
        // 두 부분 모두 같을 경우 원래 입력 순서 그대로

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String h1 = o1.split("[0-9]")[0]; //head부분 (숫자제외)
                String h2 = o2.split("[0-9]")[0];

                // 0 : 두 문자열이 같을때
                // + : h1이 h2보다 뒤
                // - : h1가 h1보다 앞
                int res = h1.toLowerCase().compareTo(h2.toLowerCase());
                if (res == 0) {
                    // HEAD가 같으면 NUMBER 부분을 추출해서 비교
                    // 숫자를 직접 빼서 비교 -> 음수일 경우 o1이 먼저, 양수일 경우 o2가 먼저 오게
                    // 0일경우는 원래 순서를 유지함
                    
                    // 문자열에서 처음 숫자 부분만 추출
                    String num1 = o1.substring(h1.length()).replaceAll("[^0-9].*", "");
                    String num2 = o2.substring(h2.length()).replaceAll("[^0-9].*", "");

                    // NUMBER 부분 비교
                    return Integer.parseInt(num1) - Integer.parseInt(num2);
                }
                return res;
            }
        });

        return files;
    }

}