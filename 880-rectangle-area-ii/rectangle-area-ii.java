import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    static class Event {
        int y, x1, x2, type; // type: +1 add, -1 remove
        Event(int y, int x1, int x2, int type) {
            this.y = y; this.x1 = x1; this.x2 = x2; this.type = type;
        }
    }

    static class SegTree {
        int n;
        int[] cnt;
        long[] len;
        int[] xs;

        SegTree(int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1; // segments between xs[i] and xs[i+1]
            cnt = new int[n * 4];
            len = new long[n * 4];
        }

        void update(int idx, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                cnt[idx] += val;
            } else {
                int m = (l + r) >>> 1;
                update(idx<<1, l, m, ql, qr, val);
                update(idx<<1|1, m, r, ql, qr, val);
            }
            if (cnt[idx] > 0) {
                len[idx] = xs[r] - xs[l];
            } else {
                len[idx] = (l + 1 == r) ? 0 : len[idx<<1] + len[idx<<1|1];
            }
        }

        long total() { return len[1]; }
    }

    public int rectangleArea(int[][] rectangles) {
        List<Event> events = new ArrayList<>();
        Set<Integer> xset = new HashSet<>();

        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            events.add(new Event(y1, x1, x2, +1));
            events.add(new Event(y2, x1, x2, -1));
            xset.add(x1); xset.add(x2);
        }

        events.sort(Comparator.comparingInt(e -> e.y));

        int[] xs = xset.stream().sorted().mapToInt(i -> i).toArray();
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < xs.length; i++) idx.put(xs[i], i);

        SegTree st = new SegTree(xs);
        long area = 0;
        int prevY = events.get(0).y;

        for (Event e : events) {
            int y = e.y;
            long coveredX = st.total();
            long dy = (long) y - prevY;
            area = (area + coveredX * dy) % MOD;

            st.update(1, 0, st.n, idx.get(e.x1), idx.get(e.x2), e.type);
            prevY = y;
        }
        return (int) area;
    }
}
