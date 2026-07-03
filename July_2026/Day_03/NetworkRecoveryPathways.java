//Question : https://leetcode.com/problems/network-recovery-pathways/description/
class Node {
    int i;
    ArrayList<Integer[]> nexts = new ArrayList<Integer[]>();
    boolean active;
    Node(int i, boolean active) {
        this.i = i;
        this.active = active;
    }
}


class Solution {
    int len;
    int lenM;
    Node[] nodes;
    long k;
    boolean can(int threshold) {
        boolean[] visited = new boolean[len];
        // idx, rmg
        PriorityQueue<Long[]> heap = new PriorityQueue<Long[]>(
            (A, B) -> {
                long a = A[1], b = B[1];
                if (b < a)  return -1;
                if (b > a)  return 1;
                return 0;
            }
        );
        heap.offer(new Long[]{0L, k});

        while (!heap.isEmpty()) {
            Long[] top = heap.poll();
            long _topIdx = top[0];
            int topIdx = (int)_topIdx;
            long topRmg = top[1];
            if (topIdx == lenM)  return true;
            if (visited[topIdx])    continue;

            visited[topIdx] = true;
            Node node = nodes[topIdx];
            for (Integer[] next: node.nexts) {
                int _nextIdx = next[0], nextCost = next[1];
                Node nextNode = nodes[_nextIdx];
                if (!nextNode.active)   continue;
                long nextIdx = (long)_nextIdx;
                if (visited[_nextIdx] || nextCost > topRmg || nextCost < threshold)
                    continue;

                Long[] addMe = new Long[]{nextIdx, topRmg - nextCost};
                heap.offer(addMe);
            }
        }

        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        len = online.length;
        lenM = len - 1;
        nodes = new Node[len];
        this.k = k;
        for (int i = 0; i < len; i++)
            nodes[i] = new Node(i, online[i]);

        int maxCost = Integer.MIN_VALUE;
        for (int[] edge: edges) {
            int f = edge[0], t = edge[1], cost = edge[2];
            Node F = nodes[f];
            F.nexts.add(new Integer[]{t, cost});
            maxCost = Math.max(maxCost, cost);
        }


        int low = 0, high = maxCost;
        if (!can(low)) return -1;

        // find latest low where 
        // can(high) === true
        while (low < high) {
            int mid = (1 + low + high) / 2;
            if (can(mid))   low = mid;
            else    high = mid - 1;
        }


        return low;
    }
}
