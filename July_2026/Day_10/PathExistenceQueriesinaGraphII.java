//Question: https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/description/
class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] valueWithIdx = new int[n][2];
        for (int i = 0; i < n; i++) valueWithIdx[i] = new int[]{nums[i], i};
        Arrays.sort(valueWithIdx, (leftPos, rightPos) -> leftPos[0] - rightPos[0]);
        int[] sortedPos = new int[n];
        for (int i = 0; i < n; i++) sortedPos[valueWithIdx[i][1]] = i;
        int[][] jump = new int[n][18];
        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (reach < i) reach = i;
            while (reach + 1 < n && valueWithIdx[reach + 1][0] - valueWithIdx[reach][0] <= maxDiff && valueWithIdx[reach + 1][0] - valueWithIdx[i][0] <= maxDiff) reach++;
            jump[i][0] = reach;
        }
        for (int j = 1; j < 18; j++) for (int i = 0; i < n; i++) jump[i][j] = jump[jump[i][j - 1]][j - 1];
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int leftPos = sortedPos[queries[i][0]], rightPos = sortedPos[queries[i][1]];
            if (leftPos > rightPos) { int t = leftPos; leftPos = rightPos; rightPos = t; }
            if (leftPos == rightPos) { result[i] = 0; continue; }
            int currPos = leftPos, steps = 0;
            for (int j = 17; j >= 0; j--) if (jump[currPos][j] < rightPos) { currPos = jump[currPos][j]; steps += (1 << j); }
            result[i] = (jump[currPos][0] >= rightPos) ? steps + 1 : -1;
        }
        return result;
    }
}