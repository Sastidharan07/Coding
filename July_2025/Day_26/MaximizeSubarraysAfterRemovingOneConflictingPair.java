//Question : https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/description/
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int m=conflictingPairs.length;
        n++;
        int[][] pairs=new int[m+1][2];
        for(int i=0;i<m;i++){
            if(conflictingPairs[i][0]>conflictingPairs[i][1]){
                int temp=conflictingPairs[i][1];
                conflictingPairs[i][1]=conflictingPairs[i][0];
                conflictingPairs[i][0]=temp;
            }
            pairs[i]=conflictingPairs[i];
        }
        pairs[m]=new int[]{n,n};
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        long totalSubs=(1l*(n-1)*n)/2;
        int maxLeft=0,maxAlterLeft=0;
        long rem=0,altRem=0,diff=0;
        for(int[] pair:pairs){
            int l=pair[0],r=pair[1];
            long cnt=1l*(n-r);
            if(l>maxLeft){
                diff=Math.max(diff,cnt*(maxAlterLeft-maxLeft)+(rem-altRem));
                altRem=rem;
                maxAlterLeft=maxLeft;
                maxLeft=l;
                rem+=(maxLeft-maxAlterLeft)*cnt;
            }else if(l>maxAlterLeft){
                altRem+=cnt*(l-maxAlterLeft);
                maxAlterLeft=l;
            }
        }
        return totalSubs-rem+diff;
    }
}
