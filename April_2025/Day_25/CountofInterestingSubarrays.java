//Question : https://leetcode.com/problems/count-of-interesting-subarrays/description/
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L);

        int prefix = 0;
        long result = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }

            int modVal = ((prefix - k) % modulo + modulo) % modulo;
            result += countMap.getOrDefault(modVal, 0L);

            int key = prefix % modulo;
            countMap.put(key, countMap.getOrDefault(key, 0L) + 1);
        }

        return result;
    }
}
