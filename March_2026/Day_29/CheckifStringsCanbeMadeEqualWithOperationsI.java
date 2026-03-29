//Question : https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // check even positions
        boolean even = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                       (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // check odd positions
        boolean odd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                      (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return even && odd;
    }
}