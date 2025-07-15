//Question : https://leetcode.com/problems/valid-word/description/
class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lower) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}
