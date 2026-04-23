//Question : https://leetcode.com/problems/sum-of-distances/description/
import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[nums.length];

        for (List<Integer> idx : map.values()) {
            int k = idx.size();

            long[] prefix = new long[k];
            prefix[0] = idx.get(0);

            for (int i = 1; i < k; i++) {
                prefix[i] = prefix[i - 1] + idx.get(i);
            }

            for (int i = 0; i < k; i++) {
                long left = (i > 0) ? (long)i * idx.get(i) - prefix[i - 1] : 0;
                long right = (i < k - 1) ?
                        (prefix[k - 1] - prefix[i]) - (long)(k - i - 1) * idx.get(i) : 0;

                ans[idx.get(i)] = left + right;
            }
        }

        return ans;
    }
}