class Solution {
    public int findCenter(int[][] edges) {
        int e1 = edges[0][0];
        int e2 = edges[0][1];
        int e3 = edges[1][0];
        int e4 = edges[1][1];

        if (e2 == e1 || e2 == e3 || e2 == e4)
            return e2;
        else
            return e1;
    }
}