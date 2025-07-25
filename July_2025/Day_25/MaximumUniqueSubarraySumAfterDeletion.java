//Question : https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        if(max<0) return max;

        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(num>0 && !set.contains(num)){
                res += num;
                set.add(num);
            }
        }
        return res;
    }
}
