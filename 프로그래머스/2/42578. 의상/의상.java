import java.util.HashMap;
class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> type = new HashMap<>();

        // 총 옷 종류 저장
        for (String[] clothe : clothes) {
            type.put(clothe[1], type.getOrDefault(clothe[1], 0) + 1);
        }

        // 경우의 수
        for(Integer count : type.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}