//Question : https://leetcode.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        HashSet <Integer> set =new HashSet<>();
        for(int i=0 ; i<n ;i++){
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        for(int i=1; i<=set.size()+1 ; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
