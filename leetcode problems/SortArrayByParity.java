//Question:https://leetcode.com/problems/sort-array-by-parity/description/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] temp=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                temp[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 != 0){
                temp[j]=nums[i];
                j++;
            }
        }
        return temp;
    }
}
