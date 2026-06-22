//Question : https://leetcode.com/problems/maximum-number-of-balloons/description/
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for(char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}
