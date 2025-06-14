//Question : https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
class Solution {
    public int minMaxDifference(int num) {
       String s=Integer.toString(num);
       String t=s;
       int index=0;
       while(index<s.length() && s.charAt(index)=='9'){
           index++;
       }
       if(index<s.length()){
         s=s.replace(s.charAt(index),'9');
       }
       t=t.replace(t.charAt(0),'0');
      
       return Integer.parseInt(s)-Integer.parseInt(t);
    }
}
