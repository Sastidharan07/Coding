//Question : https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
class Solution {
    public long maximumTripletValue(int[] nums) {
        long val=0;
        long max=Long.MIN_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                   val=(long)(nums[i]-nums[j])*nums[k];
                    max=Math.max(val,max);
                }
            }
        }
        if(max>=0){
            return max;
        }
        else{
            return 0;
        }
    }
}
