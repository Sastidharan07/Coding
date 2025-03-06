//Question:https://leetcode.com/problems/rotate-image/description/
class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int temp=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<=i;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<r/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][r-1-j];
                matrix[i][r-1-j]=temp;
            }
        }

    }
}
