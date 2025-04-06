//Question : https://leetcode.com/problems/largest-divisible-subset/description/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n], dp = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = -1;
            dp[i] = 1;
        }

        Arrays.sort(nums);

        int max = 1, idx = 0; 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }

        List<Integer> l = new ArrayList<>();
        
        while (idx != -1) {
            l.add(nums[idx]);
            idx = prev[idx];
        }

        return l;
    }
}
