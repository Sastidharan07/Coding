//Question:https://leetcode.com/problems/consecutive-characters/
class Solution {
    public int maxPower(String s) {
        int c=1;
        int max=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
                max=Math.max(max,c);
            }
            else{
                c=1;
            }
        }
        return max;
    }
}
