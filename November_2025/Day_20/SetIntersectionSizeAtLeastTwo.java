//Question : https://leetcode.com/problems/set-intersection-size-at-least-two/description/
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> {
            if(x[1] == y[1]) return y[0] - x[0];
            return x[1] - y[1];
        });
        int ans = 0, a = -1, b = -1;
        for(int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if(l > b) {
                a = r - 1;
                b = r;
                ans += 2;
            } else if(l > a) {
                a = b;
                b = r;
                ans += 1;
            }
        }
        return ans;
    }
}