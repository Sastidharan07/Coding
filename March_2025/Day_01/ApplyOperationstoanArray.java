//Question : https://leetcode.com/problems/apply-operations-to-an-array/description/
class Solution {
    public int[] applyOperations(int[] nums) {
        int a[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                nums[i-1]=nums[i]*2;
                nums[i]=0;
            }
            
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                a[j]=nums[i];
                j++;
            }
        }
        return a;
    }
}
