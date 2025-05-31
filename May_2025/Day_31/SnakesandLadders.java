//Question : https://leetcode.com/problems/snakes-and-ladders/description/
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattened = new int[n * n + 1]; 
        boolean leftToRight = true;
        int index = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flattened[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattened[index++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    if (flattened[next] != -1) {
                        next = flattened[next];
                    }

                    if (next == n * n) {
                        return moves;
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return -1; 
    }
}
