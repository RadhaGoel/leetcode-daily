import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Add boundaries
        int[] h = addBounds(hFences, m);
        int[] v = addBounds(vFences, n);

        // All possible horizontal gaps
        Set<Integer> hGaps = getGaps(h);

        int maxSide = 0;

        // Check vertical gaps against horizontal ones
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int gap = v[j] - v[i];
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == 0) return -1;
        return (int) ((long) maxSide * maxSide % MOD);
    }

    private int[] addBounds(int[] fences, int bound) {
        int[] res = new int[fences.length + 2];
        res[0] = 1;
        res[res.length - 1] = bound;
        System.arraycopy(fences, 0, res, 1, fences.length);
        Arrays.sort(res);
        return res;
    }

    private Set<Integer> getGaps(int[] arr) {
        Set<Integer> gaps = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                gaps.add(arr[j] - arr[i]);
            }
        }
        return gaps;
    }
}
