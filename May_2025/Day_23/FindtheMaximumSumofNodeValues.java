//Question : https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int fc = 0;
        long res = 0;
        for(int i=0;i<n;i++) {
            fc += (nums[i]^k)>nums[i]?1:0;
            res += Math.max((nums[i]^k),nums[i]);
        }

        if(fc%2==0) {
            return res;
        } else {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++) {
                if((nums[i]^k)<=nums[i]) {
                    max = Math.max(max,(nums[i]^k)-nums[i]);
                }
                if((nums[i]^k)>nums[i]) {
                    max = Math.max(max,-(nums[i]^k)+nums[i]);
                }
            }
            res = res + max;
            return res;
        }
    }
}
