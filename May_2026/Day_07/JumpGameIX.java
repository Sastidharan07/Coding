//Question : https://leetcode.com/problems/jump-game-ix/description/
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n];
        int[] suffMin = new int[n];

        prefMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }

        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;
        int segmentMax = nums[0];

        for (int i = 0; i < n; i++) {
            segmentMax = Math.max(segmentMax, nums[i]);

            boolean cut = (i == n - 1) || (prefMax[i] <= suffMin[i + 1]);

            if (cut) {
                for (int j = start; j <= i; j++) {
                    ans[j] = segmentMax;
                }

                start = i + 1;

                if (start < n) {
                    segmentMax = nums[start];
                }
            }
        }

        return ans;
    }
}