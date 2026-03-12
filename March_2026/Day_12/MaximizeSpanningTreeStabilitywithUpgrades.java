//Question : https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/description/
import java.util.*;

class Solution {

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int lo = 0, hi = 2000000000, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (can(n, edges, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    boolean can(int n, int[][] edges, int k, int x) {

        DSU dsu = new DSU(n);
        int upgrades = 0;
        int count = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < x) return false;
                if (!dsu.union(e[0], e[1])) return false;
                count++;
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= x) {
                if (dsu.union(e[0], e[1])) count++;
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < x && 2L * e[2] >= x) {
                if (dsu.union(e[0], e[1])) {
                    upgrades++;
                    count++;
                    if (upgrades > k) return false;
                }
            }
        }

        return count == n - 1;
    }
}