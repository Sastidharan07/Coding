//Question : https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
class Solution {
    public int minimumOperations(int[] nums) {
        int[] f = new int [101];
        int min = 0;
        for(int i = 0; i < nums.length; i++){
            f[nums[i]]++;
            if(f[nums[i]] > 1){
                min++;
                i = 3*min - 1;
                Arrays.fill(f,0);
            }
        }
        return min;
    }
}
