class Solution {
     public int findTheWinner(int n, int k) {
        return recursion(n, k) + 1;
    }

    private int recursion(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (recursion(n - 1, k) + k) % n;
    }
}