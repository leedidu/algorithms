class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    public static boolean[] dfs(int[][] computers, int j, boolean[] visited) {
        visited[j] = true; // 방문한걸로 수정

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && i != j && computers[j][i] == 1) { // 자기 자신이 아니어야함 + 1로 연결되어있어야함
                visited = dfs(computers, i, visited); //재귀함수
            }
        }
        return visited;
    }
}