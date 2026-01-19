class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(prefix, mid, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[][] prefix, int len, int threshold) {
        if (len == 0) return true;

        for (int i = 0; i + len < prefix.length; i++) {
            for (int j = 0; j + len < prefix[0].length; j++) {
                int sum = prefix[i + len][j + len]
                        - prefix[i][j + len]
                        - prefix[i + len][j]
                        + prefix[i][j];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
