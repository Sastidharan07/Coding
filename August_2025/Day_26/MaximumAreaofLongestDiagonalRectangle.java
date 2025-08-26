//Question : https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea=0;
        double maxDiagonal=0;

        for(int[] dim:dimensions){
            int len=dim[0];
            int wid=dim[1];
            double diagonal=Math.sqrt(len*len+wid*wid);
            if(diagonal>maxDiagonal){
                maxDiagonal=diagonal;
                maxArea=len*wid;
            }
            else if(diagonal==maxDiagonal &&
                    maxArea<len*wid){
                        maxArea=len*wid;
                    }
        }

        return maxArea;
    }
}
