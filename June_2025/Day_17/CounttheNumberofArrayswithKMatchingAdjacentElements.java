//Question : https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/description/
class Solution {
    static final int MOD = 1_000_000_007;

    long modPow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            y >>= 1;
        }
        return res;
    }

    long modInv(long x) {
        return modPow(x, MOD - 2);
    }

    public int countGoodArrays(int n, int m, int k) {
        long[] fact = new long[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long comb = fact[n - 1] * modInv(fact[k]) % MOD * modInv(fact[n - 1 - k]) % MOD;
        long result = comb * m % MOD * modPow(m - 1, n - 1 - k) % MOD;
        return (int) result;
    }
}
