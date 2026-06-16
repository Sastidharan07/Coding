//Question : https://leetcode.com/problems/process-string-with-special-operations-i/description/
class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*' && c != '#' && c != '%') {
                res.append(c);
            } else if (c == '#') {
                res.append(res.toString());
            } else if (c == '%') {
                res.reverse();
            } else {
                if (res.length() > 0) res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
}
