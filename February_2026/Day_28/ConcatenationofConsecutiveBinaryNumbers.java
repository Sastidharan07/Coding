//Question : https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/
class Solution {
    public int concatenatedBinary(int n) {
        int MOD = (int)1e9 + 7, bits = 0; long res = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) bits++; 
            
            res = ((res << bits) | i) % MOD;
        }

        return (int)res;
    }
}