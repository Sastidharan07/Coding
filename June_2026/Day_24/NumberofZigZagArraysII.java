//Question : https://leetcode.com/problems/number-of-zigzag-arrays-ii/description/
class Solution {
    static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;
        long[] init = new long[size];
        for (int x = 0; x < m; x++) {
            init[x] = x;
            init[m + x] = m - 1 - x;
        }
        long[][] trans = new long[size][size];
        for (int prev = 0; prev < m; prev++) {
            for (int next = 0; next < prev; next++) {
                trans[m + next][prev] = 1;
            }
            for (int next = prev + 1; next < m; next++) {
                trans[next][m + prev] = 1;
            }
        }
        long[][] power = matPow(trans, n - 2);
        long[] result = multiply(power, init);
        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }
        return (int) ans;
    }
    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }
            res[i] = sum;
        }
        return res;
    }
    private long[][] matPow(long[][] base, long exp) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }
    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                long val = a[i][k];
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;
                    res[i][j] = (res[i][j] + val * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
