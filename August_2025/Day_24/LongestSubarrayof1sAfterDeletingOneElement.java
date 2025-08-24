//Question : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
class Solution {
    public int longestSubarray(int[] nums) {
        int left=0; int ans=0;
        int zeroCount=0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) zeroCount++;
            while(zeroCount>1) {
                if(nums[left]==0) zeroCount--;
                left++;
            }
            ans=Math.max(ans,i-left+1-1);           
        }
        return ans;
    }
}
