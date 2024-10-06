class Solution {
    static int[][] diff;
    static int n, m;
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        diff = new int[n + 1][m + 1];
        // board = 건물의 내구도 , skill = 적의 공격 혹은 아군의 회복 스킬
        // kill = [type, r1, c1, r2, c2, degree] , type 1 = 공격, type 2 = 회복
        // r1~c2 = 정사각형 범위를 degree 만큼 낮추거나 높임
        for(int i = 0; i < skill.length; i++) {
            useSkill(skill[i][0], skill[i][1], skill[i][2], skill[i][3], skill[i][4], skill[i][5]);
        }

        // 누적합
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }

        for(int j = 0; j < m; j++) {
            for(int i = 1; i < n; i++) {
                diff[i][j] += diff[i-1][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if(board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 스킬을 사용할 때의 메서드
    public static void useSkill(int type, int r1, int c1, int r2, int c2, int degree) {
        // 시작과 끝점을 표시하여 누적합을 계산 -> 음수는 파괴된 건물

        int effect = (type == 1) ? -degree : degree;

        diff[r1][c1] += effect;

        // 오른쪽 끝열 다음
        if(c2 + 1 < m) diff[r1][c2 + 1] -= effect;
        // 아래쪽끝다음행
        if(r2 + 1 < n) diff[r2 + 1][c1] -= effect;

        // 우측하단 대각선 다음 칸
        if(r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += effect;
    }
}