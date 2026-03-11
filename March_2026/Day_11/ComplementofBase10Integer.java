//Question : https://leetcode.com/problems/complement-of-base-10-integer/description/
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;

        int ans=0;
        int i=0;

        while(n>0){
            int bit=n%2;

            if(bit==0){
                ans += Math.pow(2,i);
            }

            i++;
            n/=2;
        }

        return ans;
    }
}