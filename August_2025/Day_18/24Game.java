//Question : https://leetcode.com/problems/24-game/description/
class Solution {
    final double efs = 1e-6;
    public boolean judgePoint24(int[] cards) {
        List<Double> ls = new ArrayList<>();
        for(int i:cards) ls.add((double)i);
        return dfs(ls);
    }

    boolean dfs(List<Double> ls)
    {
        if(ls.size()==1){
            return Math.abs(ls.get(0)-24) < efs;
        }

        for(int i=0;i<ls.size();i++){
            for(int j=0;j<ls.size();j++){
                if(i==j) continue;
                List<Double> next = new ArrayList<>();
                for(int k=0;k<ls.size();k++){
                    if(k != i && k != j) next.add(ls.get(k));
                }

                for(double val:allPossible(ls.get(i),ls.get(j))){
                    next.add(val);
                    if(dfs(next)) return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }

    List<Double> allPossible(double a,double b){
        List<Double> ls = new ArrayList<>();
        ls.add(a+b);
        ls.add(a-b);
        ls.add(b-a);
        ls.add(a*b);
        if(Math.abs(a)>efs) ls.add(b/a);
        if(Math.abs(b)>efs) ls.add(a/b);
        return ls;
    }
}
