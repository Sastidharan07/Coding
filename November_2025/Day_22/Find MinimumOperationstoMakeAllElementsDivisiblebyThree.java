//Question : https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;  
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) {   
                nums[i] = nums[i] + 1;
                count++;
            }       
        }
        return count;
    }
}