//Question : https://leetcode.com/problems/detect-cycles-in-2d-grid/description/
class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(n*m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i+1 < n && grid[i+1][j] == grid[i][j]) { // connect to bottom
                    if (!uf.union(i*m +j, (i+1)*m + j)) return true;
                }
                if (j+1 < m && grid[i][j+1] == grid[i][j]) { // connect to right
                    if (!uf.union(i*m +j, i*m + (j+1))) return true;
                }
            }
        }
        return false;
    }
    
    class UnionFind {
        int[] parent;
        UnionFind(int sz) {
            parent = new int[sz];
            for (int i = 0; i < sz; i++) parent[i] = i;
        }
        
        boolean union(int a, int b) {
            int par_a = find(a);
            int par_b = find(b);
            
            if (par_a == par_b) return false;
            parent[par_a] = par_b;
            return true;
        }
        
        int find(int a) {
            if (a == parent[a]) return a;
            return parent[a] = find(parent[a]);
        }
    }
}