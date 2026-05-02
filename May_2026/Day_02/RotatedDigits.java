//Question : https://leetcode.com/problems/rotated-digits/description/
class Solution {

    private static boolean isValid(int n) {
        boolean isValidExist = false;

        while (n > 0) {
            int digit = n % 10;

            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValidExist = true;
            } else if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            n /= 10;
        }

        return isValidExist;
    }

    public int rotatedDigits(int n) {
        int ans = 0;

        for (int i = 2; i <= n; i++) {
            if (isValid(i)) {
                ans++;
            }
        }

        return ans;
    }
}