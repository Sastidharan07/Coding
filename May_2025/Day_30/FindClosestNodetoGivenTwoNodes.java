//Question : https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) return node1;
        
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        traverse(edges, node1, dist1);
        traverse(edges, node2, dist2);
        
        int minMaxDist = Integer.MAX_VALUE;
        int resultNode = -1;
        
        for (int i = 0; i < n; i++) {
            int currentMax = Math.max(dist1[i], dist2[i]);
            if (currentMax < minMaxDist) {
                minMaxDist = currentMax;
                resultNode = i;
            } else if (currentMax == minMaxDist && i < resultNode) {
                resultNode = i;
            }
        }
        
        return resultNode;
    }
    private void traverse(int[] edges, int start, int[] distances) {
        int current = start;
        int distance = 0;
        
        while (current != -1 && distances[current] == Integer.MAX_VALUE) {
            distances[current] = distance++;
            current = edges[current];
        }
    }
}
