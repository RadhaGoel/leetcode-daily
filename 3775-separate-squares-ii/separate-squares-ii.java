import java.util.*;

class Solution {

    static class Event {
        double y;
        int x1, x2;
        int type;
        Event(double y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegTree {
        int n;
        int[] count;
        double[] length;
        double[] xs;

        SegTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            length = new double[n * 4];
        }

        void update(int idx, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[idx] += val;
            } else {
                int mid = (l + r) / 2;
                update(idx * 2, l, mid, ql, qr, val);
                update(idx * 2 + 1, mid, r, ql, qr, val);
            }
            if (count[idx] > 0) {
                length[idx] = xs[r] - xs[l];
            } else {
                length[idx] = (l + 1 == r) ? 0 : length[idx * 2] + length[idx * 2 + 1];
            }
        }

        double total() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        Set<Integer> xSet = new HashSet<>();

        for (int[] s : squares) {
            int x1 = s[0], y1 = s[1], l = s[2];
            int x2 = x1 + l, y2 = y1 + l;

            events.add(new Event(y1, x1, x2, +1));
            events.add(new Event(y2, x1, x2, -1));

            xSet.add(x1);
            xSet.add(x2);
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        double[] xs = xSet.stream().sorted().mapToDouble(i -> i).toArray();
        Map<Double, Integer> index = new HashMap<>();
        for (int i = 0; i < xs.length; i++) index.put(xs[i], i);

        SegTree st = new SegTree(xs);

        // 1️⃣ total union area
        double totalArea = 0;
        double prevY = events.get(0).y;

        for (Event e : events) {
            double y = e.y;
            totalArea += st.total() * (y - prevY);
            st.update(1, 0, st.n, index.get((double) e.x1), index.get((double) e.x2), e.type);
            prevY = y;
        }

        // 2️⃣ find split line
        st = new SegTree(xs);
        double half = totalArea / 2.0;
        double curr = 0;
        prevY = events.get(0).y;

        for (Event e : events) {
            double y = e.y;
            double area = st.total() * (y - prevY);
            if (curr + area >= half) {
                return prevY + (half - curr) / st.total();
            }
            curr += area;
            st.update(1, 0, st.n, index.get((double) e.x1), index.get((double) e.x2), e.type);
            prevY = y;
        }

        return prevY;
    }
}
