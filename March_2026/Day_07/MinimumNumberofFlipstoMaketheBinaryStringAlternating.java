//Question : https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/
class Solution {
    public int minFlips(String s) {
        Integer dp[][]=new Integer[s.length()+1][2];
        return Math.min(eval(s,0,dp),eval(s,1,dp));
    }
    public int eval(String s,int begin,Integer dp[][]){
        int ans=compute(s,0,begin,dp);
        int n=s.length();
        for(int split=1;split<n;split++){
            int first=compute(s,split,begin,dp);
            int xor=(n-split)%2==0?begin:begin^1;
            int second=compute(s,0,xor,dp);
            xor=(split%2==0)?xor:xor^1;
            int third=compute(s,split,xor,dp);
            ans=Math.min(ans,first+second-third);
        }
        return ans;
    }
    public int compute(String s,int i,int oneorzero,Integer dp[][]){
        if(i>=s.length()) return 0;
        if(dp[i][oneorzero]!=null) return dp[i][oneorzero];
        int ans=compute(s,i+1,oneorzero^1,dp);
        if(((s.charAt(i)-'0')^oneorzero)==1) ans++;
        return dp[i][oneorzero]=ans;
    }
}