//Question : https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;  // → Initialize our operation counter to zero
        for (int i = 0; i < nums.length; i++) {  // → Go through each number in the array
            if (nums[i] % 3 != 0) {   // → Check if current number is NOT divisible by 3
                nums[i] = nums[i] + 1;  // → If not divisible, add 1 to this number
                count++;  // → Increment our operation counter
            }       
        }
        return count;  // → Return total number of operations performed
    }
}