//Question:https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder a=new StringBuilder();
        for(String b:words){
            a.append(b.charAt(0));
        }
        if(a.toString().equals(s)){
            return true;
        }
        else{
            return false;
        }
    }
}
