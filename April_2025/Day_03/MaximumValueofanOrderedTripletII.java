//Question : https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/
class Solution {
    public long maximumTripletValue(int[] nums) 
    {
        int n=nums.length;
        long prefixMax = nums[0];
        long maxDiff = 0;

        long maxVal = 0;

        for (int k = 1; k < n; k++) 
        {
            maxVal=Math.max(maxVal,maxDiff*nums[k]);
            maxDiff=Math.max(maxDiff,prefixMax-nums[k]); 
            prefixMax=Math.max(prefixMax,nums[k]);
        }
        
        return maxVal;
    }
}
