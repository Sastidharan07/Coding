//Question : https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/
class Solution {
    public int maxFreqSum(String s) {
        int vowel = 0, consonent = 0;
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                vowel = Math.max(freq[ch - 'a'], vowel);
            else
                consonent = Math.max(freq[ch - 'a'], consonent);
        }
        return consonent + vowel;
    }
}
