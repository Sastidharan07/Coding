//Question : https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/description/
class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i[] : edges){
            int v1 = i[0];
            int v2 = i[1];
            int cost = i[2];
            map.get(v1).put(v2,Math.min(map.get(v1).getOrDefault(v2,Integer.MAX_VALUE),cost));
            map.get(v2).put(v1,Math.min(map.get(v2).getOrDefault(v1,Integer.MAX_VALUE),2*cost));
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(0,0));

        // HashSet<Integer>visited = new HashSet<>(); // not single way to reach

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(dist[rm.vtx]<rm.cost){
                continue;
            }

            dist[rm.vtx] = rm.cost;

            for(int ngbr : map.get(rm.vtx).keySet()){
                if(dist[ngbr]>rm.cost+map.get(rm.vtx).get(ngbr)){
                    dist[ngbr] = rm.cost+map.get(rm.vtx).get(ngbr);
                    pq.add(new Pair(ngbr, dist[ngbr]));
                }
            }
        }

        return dist[n-1]==Integer.MAX_VALUE ? -1:dist[n-1];
        
    }

    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}