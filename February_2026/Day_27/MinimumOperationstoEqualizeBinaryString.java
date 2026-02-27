//Question : https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/description/
class Solution {
    private final int MOD = 1_000_000_007;

    public int minOperations(String s, int k) {
        int n = s.length();
        int zeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeros++;
            }
        }
        if (zeros == 0) {
            return 0;
        }
        int minZerosReachable = zeros, maxZerosReachable = zeros;
        for (int i = 1; i <= n + 1; i++) {
            int nxtMaxZeros, nxtMinZeros;
            if (minZerosReachable <= k && k <= maxZerosReachable) {
                nxtMinZeros = 0;
            } else {
                nxtMinZeros = Math.min(
                    Math.abs(minZerosReachable - k),
                    Math.abs(maxZerosReachable - k)
                );
            }
            if (minZerosReachable <= n - k && n - k <= maxZerosReachable) {
                nxtMaxZeros = n;
            } else {
                int a = n - Math.abs(n - (minZerosReachable + k));
                int b = n - Math.abs(n - (maxZerosReachable + k));
                nxtMaxZeros = Math.max(a, b);
            }
            minZerosReachable = nxtMinZeros;
            maxZerosReachable = nxtMaxZeros;

            boolean isParity = ((long) zeros + (long) i * k) % 2 == 0;

            if (isParity && minZerosReachable <= 0 && 0 <= maxZerosReachable) {
                return i;
            }
        }
        return -1;
    }
}