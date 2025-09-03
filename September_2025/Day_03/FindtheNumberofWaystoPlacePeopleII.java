//Question : https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/description/
class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b) ->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });

        int n=points.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            int maxY=Integer.MIN_VALUE;

            for(int j=i+1;j<n;j++){
                int x2=points[j][0];
                int y2=points[j][1];
                
                if(x1<=x2 && y1>=y2){
                    if(y2>maxY){
                        ans++;
                        maxY=y2;
                    }
                }
            }
        }
        return ans;
    }
}
