//Question : https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i >= 2 && str[i] == str[i - 1] && str[i] == str[i - 2]) {
                continue;
            }
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
