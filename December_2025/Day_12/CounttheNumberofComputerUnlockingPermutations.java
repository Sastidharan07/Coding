//Question : https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/description/
class Solution {
    int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        int min = complexity[0];
        int n = complexity.length-1;
        for(int i=1; i<=n; i++){
            if(complexity[i] <= min) return 0;
        }
        long res = 1;
        while(n!=0){
            res = (res*n)%MOD;
            n--;
        }
        return (int)res;
    }
}
