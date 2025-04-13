//Question : https://leetcode.com/problems/count-good-numbers/description/
class Solution {
    int MOD = 100_00_00_007;
    public long powMod(long base,long exp){
        long res=1L;
        while(exp>=1){
            if((exp&1)==1){
                res = (res * base)%MOD;
            }
            base = (base * base)%MOD;
            exp >>= 1;
        } 
        return res;
    }
    public int countGoodNumbers(long n) {
        long eves = n/2 + n%2;
        long odds = n-eves;
        long ans = powMod(5,eves);
        ans = (ans * powMod(4,odds))%MOD;
        return (int) ans;

    }
}
