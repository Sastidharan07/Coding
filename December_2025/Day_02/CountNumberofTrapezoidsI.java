//Question : https://leetcode.com/problems/count-number-of-trapezoids-i/description/
import java.util.*;

class Solution {
    static final long MOD = 1000000007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> freq = new HashMap<>();

        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0L) + 1);
        }

        List<Long> pairs = new ArrayList<>();
        for (long v : freq.values()) {
            if (v >= 2) {
                long c = v * (v - 1) / 2;
                pairs.add(c % MOD);
            }
        }

        long sum = 0, ans = 0;
        for (long x : pairs) {
            ans = (ans + x * sum) % MOD;
            sum = (sum + x) % MOD;
        }

        return (int) ans;
    }
}