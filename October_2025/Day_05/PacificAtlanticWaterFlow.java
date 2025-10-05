//Question : https://leetcode.com/problems/pacific-atlantic-water-flow/description/
import java.util.*;

class Solution {
    int rows, cols;
    int[][] heights;
    boolean[][] pacific, atlantic;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights[0][c]);         
            dfs(rows - 1, c, atlantic, heights[rows-1][c]); 
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights[r][0]);        
            dfs(r, cols - 1, atlantic, heights[r][cols-1]); 
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result ;
    }

    private void dfs(int r, int c, boolean[][] ocean, int prevHeight) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;
        if (ocean[r][c]) return; 
        if (heights[r][c] < prevHeight) return; 

        ocean[r][c] = true;
        for (int[] d : directions) {
            dfs(r + d[0], c + d[1], ocean, heights[r][c]);
        }
    }
}
