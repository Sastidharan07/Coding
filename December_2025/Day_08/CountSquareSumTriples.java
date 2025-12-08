//Question : https://leetcode.com/problems/count-square-sum-triples/description/
class Solution {
    public int countTriples(int n) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            set.add((i * i));
        }

        for(int i = n ; i >= 3 ; i--){
            int cSq = i * i;
            int b = i - 1;
            while(b >= 1){
                int bSq = b * b;
                int aSq = cSq - bSq;
                if(set.contains(aSq)){
                    count++;
                }
                b--;
            }
        }
        return count;
    }
}
