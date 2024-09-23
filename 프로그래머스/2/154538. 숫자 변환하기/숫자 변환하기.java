import java.util.*;
class Solution {
    public static int solution(int x, int y, int n) {
        int answer = 0;
        return bfs(x,y,n);
    }
    public static int bfs(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        boolean[] visited = new boolean[y + 1]; // y까지 방문

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNum = cur[0];
            int count = cur[1];

            if(curNum == y){
                return count;
            }

            if(curNum + n <= y && !visited[curNum + n]){
                queue.add(new int[]{curNum + n, count + 1});
                visited[curNum + n] = true;
            }

            if(curNum * 2 <= y && !visited[curNum * 2]){
                queue.add(new int[]{curNum * 2, count + 1});
                visited[curNum * 2] = true;
            }

            if(curNum * 3 <= y && !visited[curNum * 3]){
                queue.add(new int[]{curNum * 3, count + 1});
                visited[curNum * 3] = true;
            }
        }
        return -1;
    }
}