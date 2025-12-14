//Question : https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/
class Solution {
    public int numberOfWays(String corridor) {
       long res=1,seat=0,plant=0,totalSeat=0,MOD =1_000_000_007,n=corridor.length();
       for(int i=0;i<n;i++){
        char c = corridor.charAt(i);
        if(c=='S'){
          totalSeat++;
          seat++;
          if(seat%2 != 0){
             res = (res*(plant+1))%MOD;
             plant=0;
             seat=1;
          }
        }
        else if(seat==2) plant++;
       }
       if(totalSeat % 2 != 0 || totalSeat == 0) return 0;
       return (int)res;
    }
}
