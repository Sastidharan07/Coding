//Question : https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return sum%k;
    }
}
