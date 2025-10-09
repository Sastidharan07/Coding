//Question : https://leetcode.com/problems/swim-in-rising-water/description/
import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = Math.max(grid[0][0], grid[n - 1][n - 1]);
        int right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReach(mid, grid, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canReach(int t, int[][] grid, int n) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] > t) return false;
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            if (x == n - 1 && y == n - 1) return true;
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] <= t) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
