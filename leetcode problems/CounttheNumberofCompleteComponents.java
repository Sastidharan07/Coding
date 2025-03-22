//Question : https://leetcode.com/problems/count-the-number-of-complete-components/description/
class Solution {
    int[] parent;
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i =0; i < n; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int a = edge[0], b = edge[1], pa = parent(a), pb = parent(b);
            parent[pa] = pb;
        }
        int[] nodeCount =  new int[n];
        int[] edgeCount = new int[n];
        for(int i = 0; i < n; i++){
            nodeCount[parent(i)]++;
        }
        for(int[] edge : edges){
            edgeCount[parent(edge[0])]++;
        }
        int out = 0;
        for(int i = 0; i < n; i++){
            
            int count = nodeCount[i], expected = (count * (count - 1))/2;
            if(count == 0){
                continue;
            } else if(expected == edgeCount[i]){
                out++;
            }
        }
        return out;
    }
    int parent(int n){
        int p = parent[n];
        if(p == n){
            return p;
        }
        int realParent = parent(p);
        parent[n] = realParent;
        return realParent;
    }
}
