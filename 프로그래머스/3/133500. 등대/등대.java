import java.util.*;
class Solution {
    static int[][] dp;
    static boolean[] visited; // 방문 확인
    static List<Node> nodes;

    static class Node{
        int data; // 해당 노드 인덱스
        List<Node> next; // 연결 노드

        public Node(int data) {
            this.data = data;
            this.next = new ArrayList<>();
        }

        public int getData(){
            return data;
        }

        public List<Node> getNext(){
            return next;
        }

        public void setNext(List<Node> next){
            this.next = next;
        }
    }

    public static int solution(int n, int[][] lighthouse) {
        int answer = 0;

        nodes = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            Node node = new Node(i);
            nodes.add(node);
        }

        for (int[] i : lighthouse) {
            // 양방향 연결
            Node a = nodes.get(i[0] - 1);
            Node b = nodes.get(i[1] - 1);

            a.getNext().add(b);
            b.getNext().add(a);
        }

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        dfs(nodes.get(0));

        answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }

    public static void dfs(Node node){
        visited[node.getData()] = true;

        dp[node.getData()][0] = 0;
        dp[node.getData()][1] = 1;

        for(Node neighbor : node.getNext()){
            if(!visited[neighbor.getData()]){
                dfs(neighbor);
                dp[node.getData()][0] += dp[neighbor.getData()][1];
                dp[node.getData()][1] += Math.min(dp[neighbor.getData()][0], dp[neighbor.getData()][1]);
            }
        }
    }

}