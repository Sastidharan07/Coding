//Question : https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        int co=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=0){
                nums[i]=nums[i]/10;
                co++;
            }
            if(co%2==0){
                c++;
            }
            co=0;
        }
        return c;
    }
}
