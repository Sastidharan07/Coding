//Question : https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
class Solution {
    int[][] dp;
    long count=0;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        dp = new int[n1][n2];
        for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        return helper(nums1,nums2,0,0);
    }

    private int helper(int[] nums1,int[] nums2, int idx1, int idx2){
        if(idx1 >= nums1.length || idx2 >= nums2.length ) return Integer.MIN_VALUE;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ele = nums1[idx1]*nums2[idx2];
        int next = helper(nums1,nums2,idx1+1,idx2+1);
        int non_taken = Math.max(helper(nums1,nums2,idx1+1,idx2),helper(nums1,nums2,idx1,idx2+1));
        ele += Math.max(next,0);
        return dp[idx1][idx2] = Math.max(ele,non_taken);
    }
}