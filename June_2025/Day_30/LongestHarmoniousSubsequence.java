//Question : https://leetcode.com/problems/longest-harmonious-subsequence/description/
class Solution {
    private int getFilterResult(int[] nums, int left, int right, int min, int max) {
        int filteredResult = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] >= min && nums[i] <= max) {
                filteredResult++;
            }
        }
        return filteredResult;
    }

    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();        
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] { i, i });
            }
            map.get(nums[i])[1] = i;
        }

        int result = 0;

        for (int key : map.keySet()) {
            int[] arr = map.get(key);
            int firstOcc = arr[0];
            int lastOcc = arr[1];
            int min = key - 1;
            int max = key + 1;

            int currentLength = 0;
            if (map.containsKey(min)) {
                int minFirstOcc = map.get(min)[0];
                int minLastOcc = map.get(min)[1];
                int left = Math.min(firstOcc, minFirstOcc);
                int right = Math.max(lastOcc, minLastOcc);
                int length = getFilterResult(nums, left, right, min, key);
                currentLength = Math.max(length, currentLength);
            }

            if (map.containsKey(max)) {
                int maxFirstOcc = map.get(max)[0];
                int maxLastOcc = map.get(max)[1];
                int left = Math.min(firstOcc, maxFirstOcc);
                int right = Math.max(lastOcc, maxLastOcc);
                int length = getFilterResult(nums, left, right, key, max);
                currentLength = Math.max(length, currentLength);
            }

            result = Math.max(currentLength, result);
        }

        return result;
    }
}
