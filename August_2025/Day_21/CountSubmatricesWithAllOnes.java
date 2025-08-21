//Question : https://leetcode.com/problems/count-submatrices-with-all-ones/description/
class Solution {
    public int numSubmat(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    int minWidth=Integer.MAX_VALUE;
                    for(int k=i;k<mat.length;k++){
                        if(mat[k][j]==0){
                            break;
                        }
                        int width=0;
                        while(width+j<mat[0].length && mat[k][j+width]==1){
                            width++;
                        }
                        minWidth=Math.min(width,minWidth);
                        count+=minWidth;
                    }
                }
            }
        }
        return count;
    }
}
