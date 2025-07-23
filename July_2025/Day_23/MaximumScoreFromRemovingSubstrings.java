//Question : https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
class Solution {
    private static int remove(StringBuilder s, char a, char b, int val) {
        int n = s.length(), sz = 0;
        for (int i = 0; i < n; i++) {
            s.setCharAt(sz++, s.charAt(i));
            if (sz >= 2 && s.charAt(sz - 2) == a && s.charAt(sz - 1) == b) sz -= 2;
        }
        s.setLength(sz);
        return ((n - sz) / 2) * val;
    }

    public int maximumGain(String str, int x, int y) {
        char a1 = 'a', b1 = 'b', a2 = 'b', b2 = 'a';
        if (x < y) {
            int temp = x; x = y; y = temp;
            a1 = 'b'; b1 = 'a';
            a2 = 'a'; b2 = 'b';
        }
        StringBuilder sb = new StringBuilder(str);
        return remove(sb, a1, b1, x) + remove(sb, a2, b2, y);
    }
}
