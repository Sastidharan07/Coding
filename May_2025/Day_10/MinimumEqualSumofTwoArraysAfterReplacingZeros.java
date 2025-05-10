//Question : https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long nums1ZC = 0;
        long nums2ZC = 0;

        for(int num : nums1) {
            sum1 += num;

            if(num == 0) {
                sum1 += 1;
                nums1ZC++;
            }
        }

        for(int num : nums2) {
            sum2 += num;

            if(num == 0) {
                sum2 += 1;
                nums2ZC++;
            }
        }

        if(sum1 < sum2 &&  nums1ZC == 0) {
            return -1;
        }

        if(sum2 < sum1 &&  nums2ZC == 0) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}
