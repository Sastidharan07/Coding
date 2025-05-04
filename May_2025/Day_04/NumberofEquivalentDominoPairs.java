//Question : https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int c = 0;
        for(int i = 0 ; i<dominoes.length ; i++){
            int x = dominoes[i][0];
            int y = dominoes[i][1];

            for(int j = i+1 ; j<dominoes.length ; j++){
                int a = dominoes[j][0];
                int b = dominoes[j][1];
                if( (x==a && y==b) || (x==b && y==a) )c++;
            }
        }
        return c;
    }
}
