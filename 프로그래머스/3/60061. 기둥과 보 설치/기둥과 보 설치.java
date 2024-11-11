import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> structures = new ArrayList<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2]; // 0은 기둥, 1은 보
            int action = frame[3]; // 0은 삭제, 1은 설치

            if (action == 1) { // 설치
                structures.add(new int[]{x, y, type});
                if (!isValid(structures)) {
                    structures.remove(structures.size() - 1); // 설치 불가능하면 제거
                }
            } else { // 삭제
                structures.removeIf(s -> s[0] == x && s[1] == y && s[2] == type);
                if (!isValid(structures)) {
                    structures.add(new int[]{x, y, type}); // 삭제 불가능하면 다시 추가
                }
            }
        }

        int[][] result = structures.toArray(new int[structures.size()][]);
        Arrays.sort(result, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        return result;
    }

    public static boolean isValid(List<int[]> structures) {
        for (int[] structure : structures) {
            int x = structure[0];
            int y = structure[1];
            int type = structure[2];

            if (type == 0) { // 기둥
                if (y == 0 || // 바닥 위
                    ifContains(structures, x, y - 1, 0) || // 아래에 기둥이 있는 경우
                    ifContains(structures, x - 1, y, 1) || // 왼쪽에 보가 있는 경우
                    ifContains(structures, x, y, 1)) { // 같은 위치에 보가 있는 경우
                    continue;
                }
                return false;
            } else { // 보
                if (ifContains(structures, x, y - 1, 0) || // 아래에 기둥이 있는 경우
                    ifContains(structures, x + 1, y - 1, 0) || // 오른쪽 아래에 기둥이 있는 경우
                    (ifContains(structures, x - 1, y, 1) && ifContains(structures, x + 1, y, 1))) { // 양쪽에 보가 있는 경우
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    // 특정 구조물이 존재하는지 확인하는 함수
    public static boolean ifContains(List<int[]> structures, int x, int y, int type) {
        for (int[] structure : structures) {
            if (structure[0] == x && structure[1] == y && structure[2] == type) {
                return true;
            }
        }
        return false;
    }
}
