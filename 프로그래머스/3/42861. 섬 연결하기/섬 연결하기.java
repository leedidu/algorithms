import java.util.*;

class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int edgesUsed = 0;  // 사용된 간선의 개수

        // 비용이 낮은 것부터 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 부모 배열과 랭크 배열 초기화
        int[] parent = new int[n];
        int[] rank = new int[n];  // 트리의 높이를 추적

        for (int i = 0; i < n; i++) { // 모든 노드의 부모는 자기 자신으로 초기화
            parent[i] = i;
            rank[i] = 0;  // 초기 트리 높이는 0
        }

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];

            // 두 섬이 이미 같은 집합에 속해 있지 않으면 연결
            if (find(parent, island1) != find(parent, island2)) {
                union(parent, rank, island1, island2);
                answer += bridgeCost;
                edgesUsed++;  // 간선 사용 개수 증가

                // 모든 섬이 연결되었으면 종료 (간선의 개수는 n-1)
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return answer; // 최소 비용 반환
    }

    // Find 연산: 부모 노드를 찾음 (경로 압축 적용)
    public static int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // 경로 압축
        }
        return parent[node];
    }

    // Union 연산: 두 트리를 합침 (랭크 기반으로 트리의 깊이를 최소화)
    public static void union(int[] parent, int[] rank, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);

        // 두 노드의 루트가 다를 때 합침
        if (root1 != root2) {
            // 랭크(트리 높이)를 비교하여 더 작은 트리를 큰 트리에 연결
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;  // 랭크가 같으면 root2를 root1에 연결하고 root1의 랭크를 증가
                rank[root1]++;
            }
        }
    }
}