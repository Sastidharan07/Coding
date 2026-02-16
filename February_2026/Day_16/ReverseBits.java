//Question : https://leetcode.com/problems/reverse-bits/description/
class Solution {
    public int reverseBits(int n) {

        int reversed = 0; // Will store the reversed bits

        // Process all 32 bits of the integer
        for (int i = 0; i < 32; i++) {

            // Shift reversed left to make space for the next bit
            reversed <<= 1;

            // Add the last bit of n into reversed
            reversed |= (n & 1);

            // Shift n right to process the next bit
            n >>= 1;
        }

        // Return the number with reversed bits
        return reversed;
    }
}