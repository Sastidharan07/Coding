//Question : https://leetcode.com/problems/domino-and-tromino-tiling/
class Solution {
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int mod = 1000000007;
        long a0 = 1, a1 = 1, a2 = 2;
        long ans = 0;
        for (int i=3; i<=n; i++){
            ans = (a2 * 2 + a0) % mod;
            a0 = a1;
            a1 = a2;
            a2 = ans;
        }
        return (int)ans;
    }
}
