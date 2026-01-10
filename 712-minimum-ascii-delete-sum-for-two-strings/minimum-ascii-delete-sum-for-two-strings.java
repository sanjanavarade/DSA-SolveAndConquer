class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        // dp[j] = max ASCII sum of common subsequence
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; // dp[j-1] from previous row
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev + s1.charAt(i - 1);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        int sum1 = 0, sum2 = 0;
        for (char c : s1.toCharArray()) sum1 += c;
        for (char c : s2.toCharArray()) sum2 += c;

        return sum1 + sum2 - 2 * dp[m];
    }
}
