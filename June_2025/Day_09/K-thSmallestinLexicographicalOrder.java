//Question : https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k -= 1; 

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                current += 1;
                k -= steps;
            } else {
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1L, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
