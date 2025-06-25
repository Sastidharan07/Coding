//Question : https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/description/
class Solution {
    private long count(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int n : nums1) {
            if (n == 0) {
                if (target >= 0) count += nums2.length;
                continue;
            }

            int low = 0, high = nums2.length;
            while (low < high) {
                int mid = (low + high) / 2;
                long product = (long) n * nums2[mid];
                if (product <= target) {
                    if (n > 0) low = mid + 1;
                    else high = mid;
                } else {
                    if (n > 0) high = mid;
                    else low = mid + 1;
                }
            }

            count += (n > 0) ? low : nums2.length - low;
        }
        return count;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10_000_000_000L, right = 10_000_000_000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(nums1, nums2, mid) < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
