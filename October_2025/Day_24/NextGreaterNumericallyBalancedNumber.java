//Question : https://leetcode.com/problems/next-greater-numerically-balanced-number/description/
class Solution {
    public boolean solve(int x){
        String s = String.valueOf(x);
        int[] vec = new int[10];
        for (char ch : s.toCharArray()) vec[ch - '0']++;
        for (char ch : s.toCharArray()){
            int c = ch - '0';
            if (c == 0 || vec[c] != c) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) if (solve(i)) return i;
    }
}