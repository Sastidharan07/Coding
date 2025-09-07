//Question : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];
        int start=-n/2;
        int idx=0;
        if(n%2==1) {
            for(int i=0; i<n; i++) {
                ans[idx++]=start++;
            }
        } else {
            for(int i=0; i<=n; i++) {
                if(start==0) {
                    start++;
                    continue;
                }
                ans[idx++]=start++;
            }
        }
        return ans;
    }
}
