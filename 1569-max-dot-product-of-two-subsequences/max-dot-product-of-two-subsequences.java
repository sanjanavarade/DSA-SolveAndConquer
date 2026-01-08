class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int[][] dp = new int[n][m];

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int product= nums1[i]*nums2[j];

                int take=product;
                if(i>0 && j>0){
                    take= Math.max(take, product+dp[i-1][j-1]);
                }
                int skip1= (i>0)?dp[i-1][j]:Integer.MIN_VALUE;
                int skip2=(j>0)?dp[i][j-1]:Integer.MIN_VALUE;

                dp[i][j]= Math.max(take, Math.max(skip1, skip2));
            }
        }
        return dp[n-1][m-1];
    }
}