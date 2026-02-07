//Question : https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
class Solution {
    public int minimumDeletions(String s) {
        int b_before_a = 0, deletion = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'b') b_before_a += 1;
            else if(b_before_a > 0 ) {
                b_before_a -= 1;
                deletion += 1;
            }
        }   
        return deletion;
    }
}