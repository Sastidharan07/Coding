//Question:https://leetcode.com/problems/missing-number/description/

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return nums[i]-1;
            }
        }
        return nums.length;
    }
}
