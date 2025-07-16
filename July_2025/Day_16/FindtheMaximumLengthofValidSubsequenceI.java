//Question : https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/
class Solution {
    public int maximumLength(int[] nums) {
        int[][] patterns = {{0,0},{0,1},{1,0},{1,1}};
        int ans=0;
        for(int[] pattern : patterns){
            int ptr=0;
            int c=0;
            for(int num : nums){
                if(num%2 == pattern[ptr%2]){
                    c++;
                    ptr++;
                }
            }
        ans = Math.max(ans, c);
        }
    return ans;
    }
}
