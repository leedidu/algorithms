import java.util.*;

class Node{
    int id; // 노드번호
    List<Node> adj; // 직접 연결된 노드
    boolean visited;

    public Node(int id){
        this.id = id;
        adj = new ArrayList<Node>();
    }

    public void adj(Node n){
        adj.add(n);
    }
}

public class Main {
    static int result = 0; // 감염된 컴퓨터 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 컴퓨터 수(정점식)
        int M = sc.nextInt(); // 연결된 컴퓨터 쌍의 수(간선)

        Node[] computers = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            computers[i] = new Node(i);
        }

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            computers[a].adj(computers[b]);
            computers[b].adj(computers[a]);
        }

        dfs(computers[1]);
        System.out.println(result - 1); // 1번 컴퓨터 제외하고 연결된 컴퓨터 수
    }

    public static void dfs(Node n){
        if(n.visited) return;

        n.visited = true;
        result++;

        for(Node link : n.adj){
            dfs(link);
        }
    }
}
