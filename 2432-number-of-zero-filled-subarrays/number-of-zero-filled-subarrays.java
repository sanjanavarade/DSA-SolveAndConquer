class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count=count+1;
                
            }else{
                count=0;
            }
            result=result+count;
        }
        return result;
    }
}