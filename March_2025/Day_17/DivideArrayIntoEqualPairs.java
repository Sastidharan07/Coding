//Question : https://leetcode.com/problems/divide-array-into-equal-pairs/description/
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                i=i+1;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
