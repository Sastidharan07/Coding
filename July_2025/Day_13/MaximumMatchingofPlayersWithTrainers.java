//Question : https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i=0,j=0,n=players.length,m=trainers.length,cnt=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i<n && j<m){
            if(players[i]<=trainers[j]){
                i++;
                j++;
                cnt++;
            }else{
                j++;
            }
        }
        return cnt;
    }
}
