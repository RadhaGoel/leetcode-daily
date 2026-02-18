class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nei : graph.get(node)) {
                    if (color[nei] == 0) {
                        color[nei] = -color[node];
                        q.add(nei);
                    } else if (color[nei] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}