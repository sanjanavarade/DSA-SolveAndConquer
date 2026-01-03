class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007L;

        long same = 6;
        long diff = 6;

        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 % MOD + diff * 2 % MOD) % MOD;
            long newDiff = (same * 2 % MOD + diff * 2 % MOD) % MOD;

            same = newSame;
            diff = newDiff;
        }

        return (int)((same + diff) % MOD);
    }
}
