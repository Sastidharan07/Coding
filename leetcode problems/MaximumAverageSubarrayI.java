//Question:https://leetcode.com/problems/maximum-average-subarray-i/description/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max1 =0;
        double sum=0;
        for(int i=0;i<k;i++){
                sum+=nums[i];
            }
        max1=sum;
        for(int j=k;j<nums.length;j++){
                        sum=sum+nums[j]-nums[j-k];
                max1=Math.max(max1,sum);
            }
        return max1/k;
    }
}
