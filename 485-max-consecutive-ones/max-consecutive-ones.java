class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int one_count=0;

        for(int num:nums){
            if(num==1){
                one_count++;
                max= Math.max(max, one_count);
            }else{
                one_count =0;
            }
        }
        return max;
    }
}