//Question : https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = colors.length();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[n][26]; 
        int max = 1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i][colors.charAt(i)-'a']++;
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int nbr : map.get(node)) {
                indegree[nbr]--;
                for (int i = 0; i < 26; i++) {
                    dp[nbr][i] = Math.max(dp[nbr][i], dp[node][i]+(colors.charAt(nbr)-'a' == i ? 1 : 0));
                    max = Math.max(dp[nbr][i], max);
                }
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }
        return count == n ? max : -1;
    }
    
}
