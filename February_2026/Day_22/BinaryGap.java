//Question : https://leetcode.com/problems/binary-gap/description/
class Solution {
    public int binaryGap(int n) {
        int maxi = 0;
        int last = Integer.MAX_VALUE;
        int i = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (i-last > maxi) maxi = i-last;
                last = i;
            }
            n >>= 1;
            i++;
        }
        return maxi;
    }
}