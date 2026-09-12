import java.util.*;

class Solution {
    static class State implements Comparable<State> {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }

        public int compareTo(State other) {
            if (this.score != other.score)
                return Long.compare(this.score, other.score);
            int len = Math.min(this.indices.size(), other.indices.size());
            for (int i = 0; i < len; i++) {
                int cmp = Integer.compare(this.indices.get(i), other.indices.get(i));
                if (cmp != 0) return cmp;
            }
            return Integer.compare(this.indices.size(), other.indices.size());
        }
    }

    public int[] maximumWeight(List<List<Integer>> a) {
        // Remove duplicates, keeping the smallest original index
        Map<String, Integer> originalIndex = new LinkedHashMap<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> iv = a.get(i);
            String key = iv.get(0) + "," + iv.get(1) + "," + iv.get(2);
            if (!originalIndex.containsKey(key)) {
                originalIndex.put(key, i);
            }
        }

        List<int[]> withIndex = new ArrayList<>();
        for (Map.Entry<String, Integer> e : originalIndex.entrySet()) {
            String[] parts = e.getKey().split(",");
            withIndex.add(new int[]{
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                e.getValue()
            });
        }

        withIndex.sort((x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[2], y[2]);
        });

        int n = withIndex.size();
        int[][] intervals = new int[n][3];
        int[] origIdx = new int[n];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = withIndex.get(i)[0];
            intervals[i][1] = withIndex.get(i)[1];
            intervals[i][2] = withIndex.get(i)[2];
            origIdx[i] = withIndex.get(i)[3];
        }

        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int right = intervals[i][1];
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (intervals[mid][0] > right) hi = mid;
                else lo = mid + 1;
            }
            nextIndex[i] = lo;
        }

        // dp[i][k] = best state using intervals[i..n) with k picks left
        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++)
            dp[n][k] = new State(0, new ArrayList<>());

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new State(0, new ArrayList<>());

            int weight = intervals[i][2];

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];

                State takeNext = dp[nextIndex[i]][k - 1];
                long takeScore = takeNext.score - weight;
                List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
                takeIndices.add(origIdx[i]);
                Collections.sort(takeIndices);
                State take = new State(takeScore, takeIndices);

                dp[i][k] = (skip.compareTo(take) <= 0) ? skip : take;
            }
        }

        List<Integer> resultList = dp[0][4].indices;
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) result[i] = resultList.get(i);
        return result;
    }
}