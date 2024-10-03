import java.util.*;

class Node implements Comparable<Node> {
    int index; // 노드 번호
    int cost; // 거리

    public Node(int index, int distance) {
        this.index = index;
        this.cost = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }

    @Override
    public String toString() {
        return "[Node -> " + index + " / cost " + cost + " ]\n";
    }
}

class Solution {
    final static int INF = Integer.MAX_VALUE; // 최대 값
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 그래프 표현

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        // 각각 가는 경우의 예상 택시 비용이 같다면 따로 가도됨!!
        int answer = 0;

        // 그래프 초기화
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < fares.length; i++) { // 양방향 연결
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        int[] sCost = Dijkstra(n, s);
        int[] aCost = Dijkstra(n, a);
        int[] bCost = Dijkstra(n, b);

        // 모든 경유지에서의 비용 탐색
        int[] total = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(sCost != null && aCost != null && bCost != null){
                total[i] = sCost[i] + aCost[i] + bCost[i];
            }
        }
        Arrays.sort(total);
        return total[1];
    }

    public static int[] Dijkstra(int n, int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] smallest = new int[n + 1];
        boolean[] visited = new boolean[n + 1]; // 방문 처리
        Arrays.fill(smallest, INF); // 최대거리로 초기화

        // 최단거리 테이블의 시작지점 노드 값 = 0
        smallest[index] = 0;
        pq.add(new Node(index, 0));

        if(visited[index]) {
            return null;
        } else{
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                int nodeIdx = node.index;
                int cost = node.cost;

                visited[nodeIdx] = true;
                if (cost > smallest[nodeIdx]) {
                    continue;
                }
                for (Node linkedNode : graph.get(nodeIdx)) {
                    // 현재 노드에서 연결된 다른 노드로 가능 경로의 비용이 그 노드까지의 기존 최단경로보다 작은지 비교
                    // cost = 현재노드까지 최소비용 / linkedNode.cost = 현재노드에서 다음 노드까지 비용 / shortest[] = 각 노드까지 최소비용
                    if (cost + linkedNode.cost < smallest[linkedNode.index]) {
                        smallest[linkedNode.index] = cost + linkedNode.cost;
                        pq.offer(new Node(linkedNode.index, smallest[linkedNode.index]));
                        visited[linkedNode.index] = false;
                    }
                }
            }
            return smallest;
        }
    }
}