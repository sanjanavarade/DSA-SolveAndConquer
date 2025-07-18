class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];

        int positive =0;
        int negative =1;

        for(int i:nums){
            if(i>0){
                ans[positive ] = i;
                positive +=2;
            }else{
                ans[negative] =i;
                negative+=2;
            }
        }
        return ans;
    }
}