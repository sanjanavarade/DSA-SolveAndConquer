class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int sum=0;
        for(int x:nums)sum+=x;
        if (Math.abs(target) > sum) return 0;
        if((sum+target)%2!=0)return 0;
        int ans= (sum+target)/2;

        int[] dp = new int[ans+1];
        dp[0]=1;

        for(int i=0;i<n;i++){
            for(int j=ans;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[ans];
    }
}