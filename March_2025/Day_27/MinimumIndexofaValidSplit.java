//Question : https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = nums.get(0);
        int count = 1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)==dominant){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                dominant = nums.get(i);
                count++;
            }
        }
        int freq = 0;
        for(int num:nums){
            if(num==dominant) freq++;
        }
        int ltcount = 0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==dominant)ltcount++;
            if((ltcount*2 > (i+1)) && ((freq-ltcount)*2 > (nums.size()-(i+1)))){
                return i;
            }
        }
        return -1;
    }
}
