//Question : https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/description/
class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        int[][][] dp = new int[n+1][2][budget + 1];
        List<Integer>[] children = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) children[i] = new ArrayList<>();
        int[] deg = new int[n+1], parent = new int[n+1];
        for(int[] h : hierarchy) {
            children[h[0]].add(h[1]);
            deg[h[0]]++;
            parent[h[1]] = h[0];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) if(deg[i] == 0) queue.add(i);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int s = 0; s <= 1; s++) {
                int price = present[curr-1] >> s;
                int[] skip = new int[budget + 1], take = new int[budget + 1];
                for(int b = 0; b <= budget; b++) take[b] = ((b >= price) ? future[curr-1]-price : Integer.MIN_VALUE);

                for(int child : children[curr]) {
                    int[] dpChildSkip = dp[child][0], dpChildTake = dp[child][1];

                    int[] newSkip = new int[budget+1];
                    Arrays.fill(newSkip, Integer.MIN_VALUE);
                    for (int b = 0; b <= budget; b++) {
                        if(skip[b] == Integer.MIN_VALUE) continue;
                        for (int spend = 0; spend <= b; spend++) {
                            newSkip[b] = Math.max(newSkip[b], skip[b-spend] + dpChildSkip[spend]);
                        }
                    }

                    int[] newTake = new int[budget + 1];
                    Arrays.fill(newTake, Integer.MIN_VALUE);
                    for (int b = 0; b <= budget; b++) {
                        if(take[b] == Integer.MIN_VALUE) continue;
                        for (int spend = 0; spend <= b; spend++) {
                            newTake[b] = Math.max(newTake[b], take[b-spend] + dpChildTake[spend]);
                        }
                    }

                    skip = newSkip;
                    take = newTake;
                }

                for(int i = 0; i <= budget; i++) dp[curr][s][i] = Math.max(take[i], skip[i]);
            }
            int p = parent[curr];
            if(--deg[p] == 0) queue.offer(p);
        }
        return dp[1][0][budget];

        
    }
}
