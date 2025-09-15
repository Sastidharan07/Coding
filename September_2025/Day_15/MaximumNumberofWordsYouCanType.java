//Question : https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
         int res =0;
         var broken = new HashSet<Character>();
         for(char ch: brokenLetters.toCharArray()) {
            broken.add(ch);
         }
         for(var word: text.split(" ")) {
            var isValid = true;
            for (char ch : word.toCharArray()) {
                if (broken.contains(ch)) {
                    isValid = false;
                    break;
                }
            }
            res += isValid ? 1 : 0;
         }
        return res;
    }
}
