//Question : https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        final int MAXN = 200005;
        int[] freq = new int[MAXN];
        int[] prefixSum = new int[MAXN];

        int maxValue = Arrays.stream(nums).max().getAsInt();
        int limit = maxValue + k + 2;

        Arrays.fill(freq, 0, limit, 0);

        for (int num : nums) {
            freq[num]++;
        }

        if (numOperations == 0) {
            int res = 0;
            for (int i = 0; i < limit; i++)
                res = Math.max(res, freq[i]);
            return res;
        } else {
            prefixSum[0] = freq[0];
            for (int i = 1; i < limit; i++) {
                prefixSum[i] = prefixSum[i - 1] + freq[i];
            }

            int best = 0;

            for (int target = 0; target <= maxValue; target++) {
                int left = target > k ? target - k : 0;
                int right = (target + k) < limit ? target + k : (limit - 1);

                int total = prefixSum[right] - ((left > 0) ? prefixSum[left - 1] : 0);
                int changeable = total - freq[target];

                int possible;
                if (numOperations < changeable) {
                    possible = freq[target] + numOperations;
                } else {
                    possible = freq[target] + changeable;
                }

                if (possible > best) {
                    best = possible;
                }
            }

            return best;
        }
    }
}