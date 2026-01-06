class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0;
        int endIndex = 0; // end index in original string

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // original index mapping check
                    int originalIndex = i - 1;
                    int reversedIndex = n - j;

                    if (originalIndex - dp[i][j] + 1 == reversedIndex) {
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            endIndex = i - 1;
                        }
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}
