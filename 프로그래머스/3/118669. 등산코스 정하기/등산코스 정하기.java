import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int vertex, intensity;

        Node(int vertex, int intensity) {
            this.vertex = vertex;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Node other) {
            return this.intensity - other.intensity;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        Set<Integer> gatesSet = new HashSet<>();
        for (int gate : gates) gatesSet.add(gate);

        Set<Integer> summitsSet = new HashSet<>();
        for (int summit : summits) summitsSet.add(summit);

        // 다익스트라
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.vertex;
            int currentIntensity = current.intensity;

            if (summitsSet.contains(currentNode) || currentIntensity > intensity[currentNode]) continue;

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.vertex;
                int newIntensity = Math.max(currentIntensity, neighbor.intensity);

                if (gatesSet.contains(nextNode) || newIntensity >= intensity[nextNode]) continue;

                intensity[nextNode] = newIntensity;
                pq.offer(new Node(nextNode, newIntensity));
            }
        }

        int minSummit = -1;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minSummit = summit;
                minIntensity = intensity[summit];
            }
        }

        return new int[]{minSummit, minIntensity};
    }
}