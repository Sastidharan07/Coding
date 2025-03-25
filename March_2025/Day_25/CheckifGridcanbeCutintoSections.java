//Question : https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int N = rectangles.length;
        Arrays.sort(rectangles, (a,b) -> a[0] - b[0]);
        int currEnd = rectangles[0][2];
        int gaps = 0;
        for(int i =1; i < N; i++) {
            if (  rectangles[i][0] >= currEnd)  gaps++;
            currEnd = Math.max(currEnd, rectangles[i][2]);

        }
        if ( gaps > 1)   return true;

        Arrays.sort(rectangles, (a,b) -> a[1] - b[1]);
        currEnd = rectangles[0][3];
        gaps = 0;
        for(int i =1; i < N; i++) {
            if (  rectangles[i][1] >= currEnd)  gaps++;
            currEnd = Math.max(currEnd, rectangles[i][3]);

        }
        if ( gaps > 1)   return true;
        else return false;
        
    }
}
