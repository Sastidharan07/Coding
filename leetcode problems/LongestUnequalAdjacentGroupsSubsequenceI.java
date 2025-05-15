//Question : https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();

        if (words.length == 0 || groups.length == 0) return result;
        result.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
