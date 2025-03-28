//Question : https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        Integer idx[] = new Integer[queries.length];
        for(int i = 0;i < queries.length;i++) idx[i] = i;
        Arrays.sort(idx,(a,b) -> Integer.compare(queries[a],queries[b]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(grid[a[0]][a[1]],grid[b[0]][b[1]]));
        int ans[] = new int[queries.length];
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n]; 
        pq.add(new int[]{0,0});
        visit[0][0] = true;
        int cnt = 0;
        int moves[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0;i < queries.length;i++){
            for(;!pq.isEmpty() && queries[idx[i]] > grid[pq.peek()[0]][pq.peek()[1]];){
                var a = pq.poll();
                cnt++;
                for(var mov:moves){
                    int x = a[0] + mov[0];
                    int y = a[1] + mov[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || visit[x][y]) continue;
                    visit[x][y] = true;
                    pq.add(new int[]{x,y});
                }
            }
            ans[idx[i]] = cnt;
        }
        return ans;
    }
}
