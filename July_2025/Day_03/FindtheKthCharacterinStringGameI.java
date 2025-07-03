//Question : https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
class Solution {
    public char kthCharacter(int k) {
        return (char) ('a'+Integer.bitCount(k-1));
    }
}
