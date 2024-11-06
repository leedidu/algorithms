import java.util.*;
class Solution {
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int len = binary.length();

            // 포화 이진 트리의 노드수로 맞추기
            int fullTreeSize = 1;
            while (fullTreeSize < len) fullTreeSize = fullTreeSize * 2 + 1;

            // 필요한만큼 0을 앞에 추가해서 포화 이진 트리 구조로 변형
            binary = String.format("%" + fullTreeSize + "s", binary).replace(' ', '0');

            // 트리 검사
            answer[i] = isValidTree(binary, 0, binary.length() - 1) ? 1 : 0;
        }
        return answer;
    }

    public static boolean isValidTree(String binary, int start, int end) {
        if (start > end) return true;

        int mid = (start + end) / 2;
        char root = binary.charAt(mid);

        // 왼쪽오른쪽 서브트리가 각각 유효한지 재귀적으로 확인
        boolean leftValid = isValidTree(binary, start, mid - 1);
        boolean rightValid = isValidTree(binary, mid + 1, end);

        // 루트가 0인 경우-> 자식 노드가 1이면 안 됨
        if (root == '0' && (containsOne(binary, start, mid - 1) || containsOne(binary, mid + 1, end))) {
            return false;
        }

        return leftValid && rightValid;
    }

    // 1포함인지 확인
    public static boolean containsOne(String binary, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (binary.charAt(i) == '1') return true;
        }
        return false;
    }
}