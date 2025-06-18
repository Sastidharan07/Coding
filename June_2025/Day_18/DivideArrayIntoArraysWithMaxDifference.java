//Question : https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
       int [][]ans=new int[n/3][3];
        int m=0;
       for(int i=0;i<n/3;i++)
       {
        for(int j=0;j<3;j++)
        {
            ans[i][j]=nums[m];
            m++;
        }
        if(ans[i][2]-ans[i][0]>k)
        return new int[0][];
       }
       return ans;
    }
}
