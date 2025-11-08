//Question : https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/
class Solution {
    public int minimumOneBitOperations(int n) {
        int res = 0;
        while (n > 0) {
            res ^= n;
            n >>= 1;
        }
        return res;
    }
}