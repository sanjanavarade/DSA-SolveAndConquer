import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type; // +1 add, -1 remove

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int[] count;
        long[] length;
        int[] xs;

        SegmentTree(int[] xs) {
            this.xs = xs;
            int n = xs.length * 4;
            count = new int[n];
            length = new long[n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        Set<Integer> xSet = new HashSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, 1));
            events.add(new Event(y + l, x, x + l, -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        int[] xs = xSet.stream().sorted().mapToInt(Integer::intValue).toArray();
        Map<Integer, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            xIndex.put(xs[i], i);
        }

        for (Event e : events) {
            e.x1 = xIndex.get(e.x1);
            e.x2 = xIndex.get(e.x2);
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long totalArea = 0;
        List<long[]> slabs = new ArrayList<>();

        long prevY = events.get(0).y;
        int i = 0;

        while (i < events.size()) {
            long currY = events.get(i).y;
            long deltaY = currY - prevY;

            if (deltaY > 0) {
                long width = st.length[1];
                if (width > 0) {
                    long area = width * deltaY;
                    slabs.add(new long[]{prevY, currY, width, area});
                    totalArea += area;
                }
            }

            while (i < events.size() && events.get(i).y == currY) {
                Event e = events.get(i);
                st.update(1, 0, xs.length - 1, e.x1, e.x2, e.type);
                i++;
            }
            prevY = currY;
        }

        double half = totalArea / 2.0;
        double accumulated = 0;

        for (long[] slab : slabs) {
            long y1 = slab[0], y2 = slab[1];
            long width = slab[2];
            long area = slab[3];

            if (accumulated + area >= half) {
                return y1 + (half - accumulated) / width;
            }
            accumulated += area;
        }

        return slabs.get(slabs.size() - 1)[1];
    }
}
