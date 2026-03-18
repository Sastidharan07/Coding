//Question : https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        long[][] prefix = new long[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                prefix[i][j] = grid[i-1][j-1] + prefix[i][j-1] + (prefix[i-1][j] - prefix[i-1][j-1]);
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(prefix[i+1][j+1] > k)break;
                count++;
            }
        }
        return count;
    }
}