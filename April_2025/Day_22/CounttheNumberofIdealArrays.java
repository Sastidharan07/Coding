//Question : https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAXN = 10000;
    static final int MAXFREQ = 14;
    long[][] comb;

    public int idealArrays(int n, int maxValue) {
        comb = new long[n + MAXFREQ + 1][MAXFREQ + 1];
        for (int i = 0; i < comb.length; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAXFREQ); j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        long result = 0;

        for (int i = 1; i <= maxValue; i++) {
            Map<Integer, Integer> primeFactors = getPrimeFactors(i);
            long ways = 1;
            for (int freq : primeFactors.values()) {
                ways = (ways * comb[n + freq - 1][freq]) % MOD;
            }
            result = (result + ways) % MOD;
        }

        return (int) result;
    }

    private Map<Integer, Integer> getPrimeFactors(int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }
        if (x > 1) {
            map.put(x, 1);
        }
        return map;
    }
}
