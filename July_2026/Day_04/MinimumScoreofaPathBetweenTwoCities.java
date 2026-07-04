//Question : https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
class Solution {
    int[] root;

    private int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public int minScore(int n, int[][] roads) {
        root = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];

            root[find(x)] = find(y);
        }

        int res = 1_000_000_000;
        int g1 = find(1);

        for (int[] road : roads) {
            int x = road[0];
            int d = road[2];

            if (find(x) == g1) {
                res = Math.min(res, d);
            }
        }

        return res;
    }
}