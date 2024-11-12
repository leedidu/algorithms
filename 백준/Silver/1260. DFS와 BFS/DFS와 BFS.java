import java.util.*;

class Node implements Comparable<Node> {
    int id;
    List<Node> adj = new ArrayList<Node>();
    boolean visited = false;

    Node(int id) {
        this.id = id;
    }

    void adj(Node n){
        adj.add(n);
    }

    @Override
    public int compareTo(Node other){
        return this.id - other.id; // 정점번호가 작은것부터 방문하기 위해 정렬
    }
}

public class Main {
    static Node[] nodes;
    static StringBuilder dfsResult = new StringBuilder(); // dfs 결과 저장
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점
        int M = sc.nextInt(); // 간선
        int V = sc.nextInt(); // 탐색 시작할 정점

        nodes = new Node[N + 1]; // 1번부터 시작
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        // 정점 번호가 작은 것부터 방문 >> 인접리스트 오름차순 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(nodes[i].adj);
        }

        dfs(nodes[V]);
        System.out.println(dfsResult.toString());

        // 전체 노드 초기화
        for(int i = 1; i <= N; i++){
            nodes[i].visited = false;
        }

        bfs(nodes[V]);

        // 탐색 결과 출력
        System.out.println(bfsResult.toString());
    }

    static void dfs(Node node){
        if(node.visited) return;

        node.visited = true;
        dfsResult.append(node.id).append(" ");

        for(Node n : node.adj){
            dfs(n);
        }
    }

    static void bfs(Node start){
        Queue<Node> queue = new LinkedList<Node>();
        start.visited = true;
        queue.add(start);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            bfsResult.append(curr.id).append(" ");

            for(Node n : curr.adj){
                if(!n.visited){
                    n.visited = true;
                    queue.add(n);
                }
            }
        }
    }
}
