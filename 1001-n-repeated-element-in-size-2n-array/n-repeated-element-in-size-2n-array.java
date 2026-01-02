class Solution {
    public int repeatedNTimes(int[] nums) {
       HashSet<Integer> set= new HashSet<>();
       for(int num:nums){
        if(!set.add(num)){
            return num;
        }
       }
       return -1;
    }
}