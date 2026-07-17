//Question: https://leetcode.com/problems/sorted-gcd-pair-queries/description/
import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] multiples = new long[max + 1];
        for (int g = max; g >= 1; g--) {
            long cnt = 0;
            for (int m = g; m <= max; m += g) {
                cnt += freq[m];
            }
            multiples[g] = cnt;
        }

        long[] exact = new long[max + 1];
        for (int g = max; g >= 1; g--) {
            long total = multiples[g] * (multiples[g] - 1) / 2;
            for (int m = 2 * g; m <= max; m += g) {
                total -= exact[m];
            }
            exact[g] = total;
        }

        long[] pref = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            pref[g] = pref[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1;
            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (pref[mid] >= k) hi = mid;
                else lo = mid + 1;
            }
            ans[i] = lo;
        }
        return ans;
    }
}