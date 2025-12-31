//Question : https://leetcode.com/problems/last-day-where-you-can-still-cross/description/
class Solution {
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int rows, cols;
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.rows = row;
        this.cols = col;
        
        int left = 1, right = cells.length, answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canCross(mid, cells)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int day, int[][] cells) {
        int[][] grid = new int[rows][cols];
        
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 0) {
                queue.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            if (r == rows - 1) return true;
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                    !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }
        }
