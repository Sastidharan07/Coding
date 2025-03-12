//Question:https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int ne=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ne++;
            }
            if(nums[i]>0){
                pos++;
            }
        }
        return Math.max(ne,pos);
    }
}
