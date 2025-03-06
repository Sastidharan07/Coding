//Question:https://leetcode.com/problems/ugly-number/
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        // Divide the number by 2, 3, and 5 as long as possible
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        // If the number is reduced to 1, it's an ugly number
        return n == 1;
    }
}
