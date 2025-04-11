//Question : https://leetcode.com/problems/count-symmetric-integers/description/
class Solution {
   
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            if (isSymmetric(num)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int len = s.length();

        if (len % 2 != 0) return false;

        int mid = len / 2;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < mid; i++) {
            leftSum += s.charAt(i) - '0';
        }

        for (int i = mid; i < len; i++) {
            rightSum += s.charAt(i) - '0';
        }

        return leftSum == rightSum;
    }
}
