//Question : https://leetcode.com/problems/count-the-number-of-fair-pairs/description/
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return solve(nums,upper+1) - solve(nums,lower);
    }
    public long solve(int[] nums, int value){
        long res = 0;
        int left = 0, right = nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum<value){
                res += right-left;
                left++;
            }
            else right--;
        }
        return res;
    }
}
