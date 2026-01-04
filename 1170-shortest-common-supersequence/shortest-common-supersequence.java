class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        if (s1.equals(s2)) return s1;

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];

        // LCS DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(
                        (i > 0 ? dp[i - 1][j] : 0),
                        (j > 0 ? dp[i][j - 1] : 0)
                    );
                }
            }
        }

        // Build SCS
        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i--; j--;
            } else if (j > 0 && (i == 0 || dp[i][j - 1] > dp[i - 1][j])) {
                sb.append(s2.charAt(j));
                j--;
            } else {
                sb.append(s1.charAt(i));
                i--;
            }
        }

        while (i >= 0) {
            sb.append(s1.charAt(i));
            i--;
        }

        while (j >= 0) {
            sb.append(s2.charAt(j));
            j--;
        }

        return sb.reverse().toString();
    }
}