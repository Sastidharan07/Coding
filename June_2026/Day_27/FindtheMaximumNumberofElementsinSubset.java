//Question : https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();
        for (int x : nums) {
            long key = x;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (long start : count.keySet()) {
            long key = start;
            int total = 0;
            if (key == 1) {
                int freq = count.get(key);
                total = freq % 2 == 1 ? freq : freq - 1;
            } else {
                while (count.getOrDefault(key, 0) >= 2 && count.containsKey(key * key)) {
                    total += 2;
                    key = key * key;
                }
                total += 1;
            }
            res = Math.max(res, total);
        }
        return res;
    }
}