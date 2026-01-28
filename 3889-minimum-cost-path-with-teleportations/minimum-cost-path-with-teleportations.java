import java.util.*;

class Solution {
    static class State {
        int r, c, used;
        long cost;
        State(int r, int c, int used, long cost) {
            this.r = r;
            this.c = c;
            this.used = used;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long INF = Long.MAX_VALUE / 4;

        long[][][] dist = new long[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        // Sort cells by value
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        // pointer[used] = how many teleport cells already activated
        int[] ptr = new int[k + 1];

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int r = cur.r, c = cur.c, used = cur.used;
            long cost = cur.cost;

            if (cost != dist[r][c][used]) continue;

            // Move right
            if (c + 1 < n) {
                long nc = cost + grid[r][c + 1];
                if (nc < dist[r][c + 1][used]) {
                    dist[r][c + 1][used] = nc;
                    pq.offer(new State(r, c + 1, used, nc));
                }
            }

            // Move down
            if (r + 1 < m) {
                long nc = cost + grid[r + 1][c];
                if (nc < dist[r + 1][c][used]) {
                    dist[r + 1][c][used] = nc;
                    pq.offer(new State(r + 1, c, used, nc));
                }
            }

            // Teleport (optimized)
            if (used < k) {
                while (ptr[used] < cells.size() &&
                       cells.get(ptr[used])[0] <= grid[r][c]) {

                    int nr = cells.get(ptr[used])[1];
                    int nc = cells.get(ptr[used])[2];

                    if (dist[nr][nc][used + 1] > cost) {
                        dist[nr][nc][used + 1] = cost;
                        pq.offer(new State(nr, nc, used + 1, cost));
                    }
                    ptr[used]++;
                }
            }
        }

        long ans = INF;
        for (int i = 0; i <= k; i++)
            ans = Math.min(ans, dist[m - 1][n - 1][i]);

        return (int) ans;
    }
}
