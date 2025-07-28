class Solution {
    public boolean isPowerOfTwo(int n) {
        int x= (n &(n-1));
        if(n==0){
            return false;
        }
        if(n>0 && x==0){
            return true;
        }
        return false;
    }
}