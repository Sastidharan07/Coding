//Question : https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/
class Solution {
    private int reverseNum(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                mini = Math.min(mini, i - map.get(num));
            }
            int rev = reverseNum(num);
            map.put(rev, i);
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}
 