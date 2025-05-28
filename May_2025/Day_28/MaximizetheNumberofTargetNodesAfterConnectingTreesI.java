//Question : https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1, m = edges2.length+1;
        HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for (int[] edge : edges1) {
            if (!map1.containsKey(edge[0])) map1.put(edge[0], new ArrayList<>());
            if (!map1.containsKey(edge[1])) map1.put(edge[1], new ArrayList<>());
            map1.get(edge[0]).add(edge[1]);
            map1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            if (!map2.containsKey(edge[0])) map2.put(edge[0], new ArrayList<>());
            if (!map2.containsKey(edge[1])) map2.put(edge[1], new ArrayList<>());
            map2.get(edge[0]).add(edge[1]);
            map2.get(edge[1]).add(edge[0]);
        }
        int maxCount = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.clear();
            maxCount = Math.max(maxCount, fillCount(i,  i, map2, set, k-1, 0));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            set.clear();
            arr[i] = maxCount + fillCount(i, i, map1, set, k, 0);
        }
        return arr;
    }

    private int fillCount( int currNode, int node, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set, int dist, int curr) {
        if (set.contains(currNode) || curr > dist) return 0;
        set.add(currNode);
        int ans = 1;
        if (!map.containsKey(currNode)) return ans;
        for (int nbr : map.get(currNode)) {
            ans += fillCount(nbr, node, map, set, dist, curr+1);
        }
        return ans;
    }
}
