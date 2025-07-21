class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n - 1 - i];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}