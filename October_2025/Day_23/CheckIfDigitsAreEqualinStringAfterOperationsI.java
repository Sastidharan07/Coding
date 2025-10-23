//Question : https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
class Solution {
    public boolean hasSameDigits(String s) {

        while(s.length() > 2) {
            s = helper(s);
        }

        if(s.charAt(0)==s.charAt(1))
            return true;
        return false;

    }

    String helper(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<s.length(); i++) {
            int a = Character.getNumericValue(s.charAt(i-1));
            int b = Character.getNumericValue(s.charAt(i));
            int ch = (a+b)%10;
            sb.append(ch);
        }

        return sb.toString();
    }
}