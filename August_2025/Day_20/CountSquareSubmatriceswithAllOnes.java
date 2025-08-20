//Question : https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
class Solution {
    public int countSquares(int[][] matrix) {
        
        int ans = 0;

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix[0].length; ++j) {

                if (i + 1 < matrix.length && matrix[i + 1][j] != 0)
                    matrix[i + 1][j] += matrix[i][j];
                
                int mini = matrix[i][j];

                for (int k = 0; j + k < matrix[0].length; ++k) {

                    mini = Math.min(mini, matrix[i][j + k]);

                    if (mini < k + 1) 
                        break;
                    
                    ans++;
                }
            }

        }

        return ans;
    }
                    }
