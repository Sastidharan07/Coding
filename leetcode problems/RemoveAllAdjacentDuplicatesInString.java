//Question:https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() && s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
