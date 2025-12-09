//Question : https://leetcode.com/problems/count-special-triplets/description/
class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(), curr = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        long res = 0;
        // we go through each j
        for (int num: nums) {
            if (curr.containsKey(num * 2)) {
                int cnt = curr.get(num * 2);
                int rest = map.get(num * 2) - cnt;
                if (num == 0) rest--;
                res = (res + ((long)cnt * rest) % MOD) % MOD;
            }
            curr.put(num, curr.getOrDefault(num, 0) + 1);
        }
        return (int)res;
    }
}
