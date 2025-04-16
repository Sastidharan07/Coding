//Question : https://leetcode.com/problems/count-the-number-of-good-subarrays/description/
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            pairs += freq.getOrDefault(curr, 0);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            while (pairs >= k) {
                res += nums.length - right;
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                pairs -= freq.get(leftVal);
                left++;
            }
        }

        return res;
    }
}
