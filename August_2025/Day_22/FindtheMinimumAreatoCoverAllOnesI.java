//Question : https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/
class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length; int m=grid[0].length;
        int sr=n,er=-1,sc=m,ec=-1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sr=Math.min(sr,i);
                    er=Math.max(er,i);
                    sc=Math.min(sc,j);
                    ec=Math.max(ec,j);
                }
            }
        }

        int h=er-sr+1;
        int w=ec-sc+1;
        return h*w;
    }
}
