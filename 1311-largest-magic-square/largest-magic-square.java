class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Prefix sums
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag = new int[m + 1][n + 1];
        int[][] anti = new int[m + 1][n + 1];

        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag[i + 1][j + 1] = diag[i][j] + grid[i][j];
                anti[i + 1][j] = anti[i][j + 1] + grid[i][j];
            }
        }

        // Try squares from largest to smallest
        for (int size = Math.min(m, n); size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i][j + size] - row[i][j];

                    // Check all rows
                    boolean valid = true;
                    for (int r = i; r < i + size; r++) {
                        if (row[r][j + size] - row[r][j] != target) {
                            valid = false;
                            break;
                        }
                    }

                    // Check all columns
                    for (int c = j; valid && c < j + size; c++) {
                        if (col[i + size][c] - col[i][c] != target) {
                            valid = false;
                            break;
                        }
                    }

                    // Check diagonals
                    if (valid) {
                        int d1 = diag[i + size][j + size] - diag[i][j];
                        int d2 = anti[i + size][j] - anti[i][j + size];
                        if (d1 == target && d2 == target) {
                            return size;
                        }
                    }
                }
            }
        }

        // At least 1x1 is always magic
        return 1;
    }
}
