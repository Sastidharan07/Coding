//Question : https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int side = 0;
        int n = mat.length, m = mat[0].length;
        int[][] p_mat = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                p_mat[i][j] = mat[i - 1][j - 1];
                p_mat[i][j] += p_mat[i - 1][j] + p_mat[i][j - 1] - p_mat[i - 1][j - 1];
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int r = i + side, c = j + side;
                if(r > n || c > m) continue;
                while(p_mat[r][c] - p_mat[r][j - 1] - p_mat[i - 1][c] + p_mat[i - 1][j - 1] <= threshold){
                    side++;
                    r = i + side;
                    c = j + side;
                    if(r > n || c > m) break;
                }
            }
        }

        return side;
    }
}