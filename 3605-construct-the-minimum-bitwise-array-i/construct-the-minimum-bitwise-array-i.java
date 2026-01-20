import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // If even, impossible
            if ((x & 1) == 0) {
                ans[i] = -1;
            } else {
                int lsb = (x + 1) & -(x + 1); // lowest set bit of (x + 1)
                ans[i] = x - (lsb >> 1);
            }
        }
        return ans;
    }
}
