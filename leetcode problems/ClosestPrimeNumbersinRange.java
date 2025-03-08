//Question:https://leetcode.com/problems/closest-prime-numbers-in-range/description/
class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] result = {-1, -1};  // Default output
        int prevPrime = -1, minDiff = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {  // We already have one prime, check the difference
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        result[0] = prevPrime;
                        result[1] = i;
                    }
                }
                prevPrime = i; // Update previous prime
            }
        }
        return result;
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int j = 2; j*j <= num; j++) {
            if (num % j == 0) return false;
        }
        return true;
    }
}
