class Solution {

    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Find search boundaries
        for (int[] sq : squares) {
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + sq[2]);
        }

        // Binary search for precision
        for (int i = 0; i < 60; i++) { // enough for 1e-5 accuracy
            double mid = (low + high) / 2;

            double below = 0.0;
            double above = 0.0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double top = y + l;

                if (mid <= y) {
                    // Entire square above the line
                    above += l * l;
                } else if (mid >= top) {
                    // Entire square below the line
                    below += l * l;
                } else {
                    // Line cuts the square
                    below += l * (mid - y);
                    above += l * (top - mid);
                }
            }

            if (below < above) {
                low = mid;   // move line up
            } else {
                high = mid;  // move line down
            }
        }

        return low;
    }
}
