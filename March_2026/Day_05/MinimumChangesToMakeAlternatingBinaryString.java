//Question : https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/
class Solution {
    public int minOperations(String s) {
        return Math.min(solve(s,0),solve(s,1));
    }
    int solve(String s, int prev){
        int n = s.length();
        int curr;
        int res = 0;
        
        if((s.charAt(0) - '0') != prev) res++;     
        for(int i = 1; i < n; i++){
            curr = s.charAt(i) - '0';
            if(curr != (1^prev)){
                res++;
                curr = 1 ^ prev; 
            }
            prev = curr;
        }
        return res;
    }
}