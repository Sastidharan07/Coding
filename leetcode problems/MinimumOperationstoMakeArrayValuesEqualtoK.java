//Question : https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/
class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> uni=new HashSet<>();
        HashSet<Integer> un=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>k){
                uni.add(nums[i]);
            }
            if(nums[i]==k){
                un.add(nums[i]);
            }
            if(nums[i]<k){
                return -1;
            }
        }
        if(un.size()==1 && uni.size()==0){
            return 0;
        }
        else{
            return uni.size();
        }
    }
}
