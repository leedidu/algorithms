class Solution {
    static char[][] map;
    static int answer;
    static boolean[][] visited;
    
    public static int solution(int m, int n, String[] board) {
        
        map = new char[m][n];
        answer = 0;
        // 보드를 2차원 배열로 변환
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        // 블록을 계속해서 제거할 수 있는 동안 반복
        while (true) {
            visited = new boolean[m][n]; // 매번 visited 배열 초기화
            if (!remove(m, n)) {  // 제거할 블록이 없으면 종료
                break;
            }
            dropBlocks(m, n);  // 블록을 아래로 내림
        }

        return answer; // 제거된 블록 수 반환
    }

    // 블록 제거함수
    public static boolean remove(int m, int n) {
        boolean found = false;

        // 2x2 블록 탐색 및 표시
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char ch = map[i][j];
                if (ch != '-' && map[i][j + 1] == ch && map[i + 1][j] == ch && map[i + 1][j + 1] == ch) {
                    visited[i][j] = true;
                    visited[i][j + 1] = true;
                    visited[i + 1][j] = true;
                    visited[i + 1][j + 1] = true;
                    found = true; // 제거할 블록이 있음
                }
            }
        }

        // 표시된 블록 제거
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    map[i][j] = '-'; // 블록 제거
                    answer++; // 제거된 블록 수 증가
                }
            }
        }

        return found;
    }

    // 블록을 아래로 떨어뜨리는 함수
    public static void dropBlocks(int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > 0; i--) {  // 아래에서부터 채워나감
                if (map[i][j] == '-') {
                    // 위쪽 블록을 찾아서 현재 위치로 내림
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '-') {
                            map[i][j] = map[k][j];
                            map[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
}