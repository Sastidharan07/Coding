//Question : https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/description/
class LCA {

    private int n;
    private int log;
    private int[] depth;
    private List<Integer>[] graph;
    private int[][] up;

    public LCA(int[][] edges, int root) {
        n = edges.length + 1;
        log = (int) (Math.log(n) / Math.log(2)) + 1;
        graph = new ArrayList[n + 1];
        depth = new int[n + 1];
        up = new int[n + 1][log];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(root, 0);
        for (int j = 1; j < log; j++) {
            for (int u = 1; u <= n; u++) up[u][j] = up[up[u][j - 1]][j - 1];
        }
    }

    private void dfs(int u, int p) {
        up[u][0] = p;
        for (int v : graph[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u);
        }
    }

    public int lca(int u, int v) {
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int j = log - 1; j >= 0; j--) {
            if (depth[u] <= depth[up[v][j]]) v = up[v][j];
        }
        if (u == v) return u;
        for (int j = log - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    public int dist(int u, int v) {
        int p = lca(u, v);
        return depth[u] + depth[v] - 2 * depth[p];
    }
}

class Solution {

    private static final int MOD = 1_000_000_007;
    private static final int N = 100_010;
    private static final int[] pow2 = new int[N];

    static {
        pow2[0] = 1;
        for (int i = 1; i < N; i++) pow2[i] = (int) ((long) pow2[i - 1] * 2 % MOD);
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        LCA lca = new LCA(edges, 1);

        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u != v) result[i] = pow2[lca.dist(u, v) - 1];
        }
        return result;
    }
}
