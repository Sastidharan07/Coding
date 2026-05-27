//Question : https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i;
            }
            else {
                int idx = ch - 'A';
                if(firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < 26; i++) {
            if(lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                ans++;
            }
        }

        return ans;
    }
}
