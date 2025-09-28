//Question : https://leetcode.com/problems/largest-perimeter-triangle/description/
class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length; 
        //edge case
        if(n<3) return 0; 
        Arrays.sort(nums);
        //all zeroes 
        if(nums[n-1]==0) return 0; 
        //sliding windows where e = [n-1,2] 
        int a,b,c; 
        while(n>=3){
            c = nums[n-1];
            b = nums[n-2];
            a = nums[n-3]; 
            //check valid. 
            //check if no length is zero. 
            if(a<=0) break; 
            if(c-b < a) return a+b+c; 
            //move to next window. 
            n--; 
        }
        return 0; 
    }
}
