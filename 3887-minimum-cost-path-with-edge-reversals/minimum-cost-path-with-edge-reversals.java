import java.util.*;

class Solution {
    static class Pair {
        int node;
        long cost;
        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        List<int[]>[] rev = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            rev[v].add(new int[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            long d = cur.cost;

            if (d > dist[u]) continue;

            // Normal edges
            for (int[] e : graph[u]) {
                int v = e[0], w = e[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }

            // Reversed edges
            for (int[] e : rev[u]) {
                int v = e[0], w = e[1];
                long nd = d + 2L * w;
                if (dist[v] > nd) {
                    dist[v] = nd;
                    pq.offer(new Pair(v, nd));
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
