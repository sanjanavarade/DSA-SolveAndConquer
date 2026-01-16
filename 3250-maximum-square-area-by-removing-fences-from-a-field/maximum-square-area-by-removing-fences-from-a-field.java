import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // Step 1: add boundaries
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);
        for (int x : hFences) h.add(x);

        v.add(1);
        v.add(n);
        for (int y : vFences) v.add(y);

        Collections.sort(h);
        Collections.sort(v);

        // Step 2: compute all horizontal gaps
        Set<Integer> horizontalGaps = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                horizontalGaps.add(h.get(j) - h.get(i));
            }
        }

        // Step 3: find largest matching vertical gap
        long maxSide = -1;
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                int gap = v.get(j) - v.get(i);
                if (horizontalGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        // Step 4: result
        if (maxSide == -1) return -1;

        return (int)((maxSide * maxSide) % MOD);
    }
}
