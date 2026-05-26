//Question : https://leetcode.com/problems/count-the-number-of-special-characters-i/
class Solution {
    public int numberOfSpecialChars(String w) {
        int x = 0;
        Set<Character> a = new HashSet<>(), b = new HashSet<>();

        for (char c : w.toCharArray())
            if (Character.isLowerCase(c)) a.add(c);
            else b.add(Character.toLowerCase(c));
        for (char c : a)
            if (b.contains(c)) x++;

        return x;
    }
}
