//Question : https://leetcode.com/problems/minimum-removals-to-balance-array/description/
class Solution {
    public int minRemoval(int[] nums, int k) {
       Arrays.sort(nums);
       int i=0,j=0;
int m=0;
       while(j<nums.length){
        if((long)nums[i]*k>=nums[j]){
m= Math.max(m,j-i+1);
             j++;
        }
        else{
            i++;
        }
       }
       return   nums.length -m ;
    }
}
