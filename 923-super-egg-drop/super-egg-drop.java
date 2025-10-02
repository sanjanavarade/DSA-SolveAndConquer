class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        int m = 0; // number of moves

        // Keep increasing moves until we can cover all floors
        while (dp[k][m] < n) {
            m++; // try one more move

            for (int i = 1; i <= k; i++) {
                // If we drop from a floor:
                // 1. Egg breaks -> check below floors -> dp[i-1][m-1]
                // 2. Egg doesn't break -> check above floors -> dp[i][m-1]
                // So total floors = sum of both + current floor
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }

        return m; 
    }
}