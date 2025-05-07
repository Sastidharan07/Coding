//Question : https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/
class Pair implements Comparable<Pair> {
    int i, j, time;
    Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
    public int compareTo(Pair other) {
        return this.time - other.time;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int x = current.i, y = current.j, t = current.time;

            if (x == m - 1 && y == n - 1) {
                return t;
            }

            if (dist[x][y] < t) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int arrivalTime = t + 1;
                    int wait = 0;
                    if (dist[x][y] < moveTime[nx][ny]) {
                        wait = moveTime[nx][ny] - dist[x][y];
                    }
                    arrivalTime += wait;
                    if (arrivalTime < dist[nx][ny]) {
                        dist[nx][ny] = arrivalTime;
                        pq.offer(new Pair(nx, ny, arrivalTime));
                    }
                }
            }
        }
        return -1;
    }
}
