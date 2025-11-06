//Question : https://leetcode.com/problems/power-grid-maintenance/description/
class Solution {
    static class DSU {
        int[] parent;
        
        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX; // Union by attaching to rootX
            }
        }
    }
    
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Initialize DSU and connect cities
        DSU dsu = new DSU(c);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }
        
        // Step 2: Build component -> online cities mapping
        Map<Integer, TreeSet<Integer>> componentOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            componentOnline.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }
        
        // Step 3: Track offline cities and process queries
        boolean[] isOffline = new boolean[c + 1];
        List<Integer> result = new ArrayList<>();
        
        for (int[] query : queries) {
            int type = query[0];
            int node = query[1];
            
            if (type == 1) {
                // Query: find smallest online city in component
                if (!isOffline[node]) {
                    // If query node is online, return itself
                    result.add(node);
                } else {
                    // Find smallest online in the component
                    int root = dsu.find(node);
                    TreeSet<Integer> onlineCities = componentOnline.get(root);
                    if (onlineCities == null || onlineCities.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(onlineCities.first());
                    }
                }
            } else {
                // Maintenance: take city offline
                if (!isOffline[node]) {
                    isOffline[node] = true;
                    int root = dsu.find(node);
                    TreeSet<Integer> onlineCities = componentOnline.get(root);
                    if (onlineCities != null) {
                        onlineCities.remove(node);
                    }
                }
            }
        }
        
        // Convert result to array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}