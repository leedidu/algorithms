class Solution {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        // 선수의수, 경기결과 => 정확하게 순위를 매길 수 있는 선수의 수
        // 이차원 배열 중 앞에 있는 수가 이긴것
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) { // 직접적인 승/패 2차원 행렬 표현
            for (int j = 0; j < results[i].length; j++) { // [0] 인덱스가 이김
                int winner = results[i][0]; // 승자
                int loser = results[i][1]; // 패자
                graph[winner][loser] = 1;
                graph[loser][winner] = -1;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){ // i > k > j
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if(graph[i][k] == -1 && graph[k][j] == -1){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int num = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != 0) num+=1;
            }
            if(num == n - 1) answer++;
        }
        return answer;
    }
}