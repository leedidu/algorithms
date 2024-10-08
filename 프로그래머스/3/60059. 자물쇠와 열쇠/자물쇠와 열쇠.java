import java.util.*;


class Solution {
    static int n;
    static int m;
    static int[][] key;
    public static boolean solution(int[][] key1, int[][] lock) {
        /*
        * 1. 자물쇠의 영역을 벗어난 부분에있는 열쇠는 자물쇠에 영향X
        * 2. 영역 내에서는 무조건 맞아야
        * 3. 자물쇠의 모든 홈을 채워야함
        * 4. 회전 가능
        * */

        n = lock.length;
        m = key1.length;
        key = key1;

        int[][] lockArray = new int[n + 2 * m][n + 2 * m];

        // 자물쇠를 n * m 크기로 늘림 -> 여백 주기 위해서
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lockArray[i + m][j + m] = lock[i][j];
            }
        }

        // 동서남북 회전
        // 회전할 때 -> 마지막열(--)이 시작행(++)이 됨

        for(int i = 0; i < 4; i++){
            key = rotate(key);
            for(int x = 0; x <= m + n; x++){ // 확장시킨 범위 내에서 키가 이동할 수 있는건 n * 2
                for(int y = 0; y <= m + n; y++){
                    if(check(key, lockArray, x, y)) return true;
                }
            }
        }
        return false;
    }

    // 열쇠 회전
    public static int[][] rotate(int[][] key){
        int[][] rotate = new int[m][m];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < m; j ++){
                rotate[j][m - 1 - i] = key[i][j];
            }
        }
        return rotate;
    }

    public static boolean check(int[][] key, int[][] lock, int startX, int startY){
        int[][] temp = new int[n + 2 * m][n + 2 * m];

        for(int i = 0; i < n + 2 * m; i ++){
            for(int j = 0; j < n + 2 * m; j ++){
                temp[i][j] = lock[i][j];
            }
        } // lock 배열 복사

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j ++){
                temp[startX + i][startY + j] += key[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i + m][j + m] != 1){
                    return false;
                }
            }
        }
        return true;
    }

}