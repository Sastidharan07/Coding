//Question : https://leetcode.com/problems/set-matrix-zeroes/description/
class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] map = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    map[i][j] = 1;
                } 
            }
        }

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(map[i][j]==1){
                    for(int k = 0;k<matrix[0].length;k++) matrix[i][k] = 0;
                    for(int k = 0;k<matrix.length;k++) matrix[k][j] = 0;
                }
            }
        }
        
    }
}
