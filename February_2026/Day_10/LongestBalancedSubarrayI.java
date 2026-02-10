//Question : https://leetcode.com/problems/longest-balanced-subarray-i/description/
class Solution {
    public int longestBalanced(int[] nums) {
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> set1=new HashSet<>();
            HashSet<Integer> set2=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                   set1.add(nums[j]);
                }
                else{
                    set2.add(nums[j]);
                }
                if(set1.size()==set2.size()){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        if(maxlen==Integer.MIN_VALUE){
            return 0;
        }
        return maxlen;
    }
}