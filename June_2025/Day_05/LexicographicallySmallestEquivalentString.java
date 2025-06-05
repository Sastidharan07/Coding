//Question : https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
class Solution {
    int[]parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
       parent =new int[26];
        for (int i = 0; i <26 ; i++) {
            parent[i]=i;
        }
        for (int i = 0; i <s1.length() ; i++) {
            union(s1.charAt(i)-97,s2.charAt(i)-97);
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <baseStr.length() ; i++) {
            int c=find(baseStr.charAt(i)-97);
            sb.append((char)(c+97));
        }
        return sb.toString();
    }
    private int find(int i){
        if (parent[i]==i)return i;
        return find(parent[i]);
    }
    private void union(int i,int j){
        int iparent=find(i);
        int jparent=find(j);
        if (iparent<jparent){
            parent[jparent]=iparent;
        }else {
            parent[iparent]=jparent;
        }
    }
}
