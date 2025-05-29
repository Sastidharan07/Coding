//Question : https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> graph1 = new ArrayList<>();
        int n = edges1.length+1;
        for(int i=0; i<n; ++i) {
            graph1.add(new ArrayList<>());
        }
        for(int[] i:edges1) {
            graph1.get(i[0]).add(i[1]); graph1.get(i[1]).add(i[0]);
        }
        Set<Integer> t1gr1 = new HashSet<>();
        Set<Integer> t1gr2 = new HashSet<>();
        boolean[] visited1 = new boolean[n];
        dfs(graph1, visited1, t1gr1, t1gr2, 0, 1);
        List<List<Integer>> graph2 = new ArrayList<>();
        int m = edges2.length+1;
        for(int i=0; i<m; ++i) {
            graph2.add(new ArrayList<>());
        }
        for(int[] i:edges2) {
            graph2.get(i[0]).add(i[1]); graph2.get(i[1]).add(i[0]);
        }
        int[] t2GrSize = new int[2];
        boolean[] visited2 = new boolean[m];
        dfs(graph2, visited2, t2GrSize, 0, 1);
        int[] ans = new int[n];
        int maxTargTree2 = Math.max(t2GrSize[0], t2GrSize[1]);
        for(int i=0; i<n; ++i) {
            if(t1gr1.contains(i)) {
                ans[i] = t1gr1.size() + maxTargTree2;
            } else {
                ans[i] = t1gr2.size() + maxTargTree2;
            }
        }
        return ans;        
    }
    private void dfs(List<List<Integer>> graph, boolean[] visited, int[] t2GrSize, int node, int flag) {
        if(flag == 1) {
            ++t2GrSize[0];
        } else {
            ++t2GrSize[1];
        }
        visited[node] = true;
        for(int neigh : graph.get(node)) {
            if(!visited[neigh]) {
                dfs(graph, visited, t2GrSize, neigh, -flag);
            }
        }
    }
    private void dfs(List<List<Integer>> graph, boolean[] visited, Set<Integer> gr1, Set<Integer> gr2, int node, int flag) {
        if(flag == 1) {
            gr1.add(node);
        } else {
            gr2.add(node);
        }
        visited[node] = true;
        for(int neigh : graph.get(node)) {
            if(!visited[neigh]) {
                dfs(graph, visited, gr1, gr2, neigh, -flag);
            }
        }
    }
}
