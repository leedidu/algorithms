class Solution {
    static char[] dir = {'d', 'l', 'r', 'u'}; // 아래, 왼, 오, 위
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String answer = null;

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(r - x) + Math.abs(c - y); // 최소 거리 계산

        if(dist > k || (k - dist) % 2 != 0) return "impossible"; // 못가는 경우 >> 짝수가 아니어도 안됨

        dfs(n, m, x, y, r, c, k, new StringBuilder());
        return answer != null ? answer : "impossible";
    }

    public static void dfs(int n, int m, int x, int y, int r, int c, int k, StringBuilder path) {
        if (answer != null) return;

        // 남은 거리 > 최소 이동거리일 경우
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if(dist > k) return;

        // 성공
        if(dist == k && x == r && y == c) {
            answer = path.toString();
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || ny < 1 || nx > n || ny > m) continue; // 범위 벗어날 경우

            path.append(dir[i]);
            dfs(n, m, nx, ny, r, c, k - 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}