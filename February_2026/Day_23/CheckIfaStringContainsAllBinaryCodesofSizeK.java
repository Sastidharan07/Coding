//Question : https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
class Solution {
    public boolean hasAllCodes(String s,int k){
        if(s.length()<k)return false;
        HashSet<String>set=new HashSet<>();
        int st=0;
        int e=k;
        while(e<=s.length()){
            set.add(s.substring(st,e));
            st++;
            e++;

        }
        return set.size()==(1<<k);
    }
}