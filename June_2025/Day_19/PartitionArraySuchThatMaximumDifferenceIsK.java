//Question : https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/
class Solution {
    public int partitionArray(int[] nums, int k) {
      
      Arrays.sort(nums);

      int ans=1;
      int min=nums[0];

      for(int i=1;i<nums.length;i++){
            if(nums[i]-min<=k){
               continue;
            }
            else{
                ans++;
                min=nums[i];
            }
      }

      return ans;
      
    }
}
