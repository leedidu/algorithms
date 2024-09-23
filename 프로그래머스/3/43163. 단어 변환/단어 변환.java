class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)) { // 똑같은 경우
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]) { continue; }
            int num = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) {
                    num++;
                }
            }

            if(num == begin.length() - 1) { // 알파벳 하나 빼고 동일한 경우
                visited[i] = true;
                // 재귀 함수 -> begin을 target으로 바꿔서 호출
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}