//Question : https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int k=0;
        for(int i=1;i<nums.length;i++){
            k =0;

            if(i==nums.length-1){
                k = Math.abs(nums[i] - nums[0]);
                max = Math.max(max,k);
            }
            

            k = Math.abs(nums[i] - nums[i-1]);
            max = Math.max(max,k);

        }

        return max;
    }
}
