//Question : https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/description/
class Solution {
    public static final int MOD = (int)1e9 + 7;
    public int assignEdgeWeights(int[][] edges){
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();

        //adj-list

        for(int edge[] : edges){
            HashSet<Integer> node1 = hm.getOrDefault(edge[0],new HashSet<>()); 
            node1.add(edge[1]);
            hm.put(edge[0],node1);
            HashSet<Integer> node2 = hm.getOrDefault(edge[1],new HashSet<>()); 
            node2.add(edge[0]);
            hm.put(edge[1],node2);
        }

        //bfs-to-get-max-depth

        int n = bfs(hm,edges.length + 1);
        System.out.println(n);
        //power-Fn

        return (int)power(2,n - 1);
    }
    private long power(int num,int n){
        long currPow = num,res = 1;
        while(n > 0){
            if((n & 1) == 1){
                res = (res * currPow) % MOD;
            }
            currPow = (currPow * currPow) % MOD;
            n = n >> 1;
        }
        return res;
    }
    private int bfs(HashMap<Integer,HashSet<Integer>> hm,int n){
        boolean[]visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int maxDepth = -1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- != 0){
                int node = q.poll();
                HashSet<Integer> connectedNodes = hm.get(node);
                for(int ele : connectedNodes){
                    if(visited[ele]){
                        continue;
                    }
                    visited[ele] = true;
                    q.offer(ele);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}