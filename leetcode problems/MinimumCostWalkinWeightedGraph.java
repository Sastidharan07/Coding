//Question : https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/
class DisJointSet {
    int[] parent;
    int[] size;
    int[] minCost;

    DisJointSet(int n) {
        parent=new int[n];
        size=new int[n];
        minCost=new int[n];

        for (int i=0;i<n;i++) {
            parent[i]=i;
            size[i]=1;
            minCost[i]=Integer.MAX_VALUE;
        }
    }

    public int findUParent(int node) {
        if (parent[node]==node)
            return node;

        return parent[node]=findUParent(parent[node]);
    }

    public void unionFind(int u,int v,int wt) {
        int uParU=findUParent(u);
        int uParV=findUParent(v);

        if (uParU==uParV) {
            minCost[uParU]&=wt;
            return;
        }

        if (size[uParU]>=size[uParV]) {
            parent[uParV]=uParU;
            size[uParU]+=size[uParV];
            minCost[uParU]&=(minCost[uParV]&wt);
        } else {
            parent[uParU]=uParV;
            size[uParV]+=size[uParU];
            minCost[uParV]&=(minCost[uParU]&wt);
        }
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisJointSet disJointSet=new DisJointSet(n);
        int[] res=new int[query.length];

        for (int[] e: edges) {
            int u=e[0];
            int v=e[1];
            int wt=e[2];

            disJointSet.unionFind(u,v,wt);
        }
        
        for (int i=0;i<query.length;i++) {
            int src=query[i][0];
            int dest=query[i][1];

            if (disJointSet.findUParent(src)==disJointSet.findUParent(dest))
                res[i]=disJointSet.minCost[disJointSet.findUParent(src)];
            else
                res[i]=-1;
        }

        return res;
    }
}
