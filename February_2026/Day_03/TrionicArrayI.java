//Question : https://leetcode.com/problems/trionic-array-i/description/
class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length==3) {
           return false;
        }
        int index = -1;
        for(int i=0;i<nums.length-2;i++) {
          if(nums[i]>=nums[i+1]) {
            index = i;
            break;
          }
        }
        if(index==0 || index==-1) {
            return false;
        }

        for(int i=index;i<nums.length-1;i++) {
          if(nums[i]<=nums[i+1]) {
            index = i;
            break;
          }
        }

        if(index==0 || index==-1) {
            return false;
        }

        for(int i=index;i<nums.length-1;i++) {
          if(nums[i]>=nums[i+1]) {
            return false;
          }
        }
      return true;
    }
}