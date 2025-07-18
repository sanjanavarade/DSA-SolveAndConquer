class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int leader = -1;
        for(int i=arr.length-1;i>=0;i--){
            ans[i]=leader;
            leader=Math.max(leader, arr[i]);
        }
        return ans;
    }
}