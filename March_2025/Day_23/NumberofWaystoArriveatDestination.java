//Question : https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int t = road[2];
            adj.get(u).add(new int[] {v, t});
            adj.get(v).add(new int[] {u, t});
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] res = new long[n];
        int[] pathCount = new int[n];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0;
        pathCount[0] = 1;
        pq.offer(new long[]{0, 0});
        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            long curTime = cur[0];
            int curNode = (int) cur[1];
            if(curTime > res[curNode]) {
                continue;
                }
            for(int[] nbr : adj.get(curNode)) {
                int adjNode = nbr[0];
                int roadTime = nbr[1];
                if(curTime + roadTime < res[adjNode]) {
                    res[adjNode] = curTime + roadTime;
                    pathCount[adjNode] = pathCount[curNode];
                    pq.offer(new long[] {res[adjNode], adjNode});
                } else if(curTime + roadTime == res[adjNode]) {
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[curNode]) % MOD;
                }
            }
        }
        return pathCount[n - 1];
    }
}
