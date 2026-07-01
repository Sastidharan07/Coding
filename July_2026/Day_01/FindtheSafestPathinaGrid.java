//Question : https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/
class Solution {
    private final int[] row = {0, 0, -1, 1};
    private final int[] col = {-1, 1, 0, 0};

    private void bfs(int[][] grid, int[][] score, int n) {
        Queue<int[]> queue = new LinkedList<>();

        // Finding all thieves
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    score[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int s = score[x][y];

            for (int k = 0; k < 4; k++) {
                int newX = x + row[k];
                int newY = y + col[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n
                        && score[newX][newY] > s + 1) {

                    score[newX][newY] = s + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] score = new int[n][n];
        for (int[] arr : score)
            Arrays.fill(arr, Integer.MAX_VALUE);

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = grid.get(i).get(j);

        bfs(mat, score, n);

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{score[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int safe = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == n - 1 && y == n - 1)
                return safe;

            if (vis[x][y])
                continue;

            vis[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int newX = x + row[k];
                int newY = y + col[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n
                        && !vis[newX][newY]) {

                    int newSafe = Math.min(safe, score[newX][newY]);
                    pq.offer(new int[]{newSafe, newX, newY});
                }
            }
        }

        return -1;
    }
}
