//Question : https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
class Solution {
    public String answerString(String word,int numFriends) {
        if(numFriends==1){
            return word;
        }
        String maxSuffix=lastSubstring(word); // Get largest suffix
        int totalLen=word.length();
        int suffixLen=maxSuffix.length();

        // Return substring of valid length from maxSuffix
        return maxSuffix.substring(0,Math.min(suffixLen,totalLen-numFriends+1));
    }

    // Finds the lexicographically last substring in s
    public String lastSubstring(String s) {
        int start=0,candidate=1,length=s.length();

        // Loop to find the best starting index
        while(candidate<length) {
            int offset=0;

            // Compare characters at current positions
            while(candidate+offset<length && s.charAt(start+offset)==s.charAt(candidate+offset)) {
                offset++;
            }

            // Update start if candidate is better
            if(candidate+offset<length && s.charAt(start+offset)<s.charAt(candidate+offset)) {
                int prevStart=start;
                start=candidate;
                candidate=Math.max(candidate+1,prevStart+offset+1);
            } else {
                candidate+=offset+1;
            }
        }

        // Return substring from best index
        return s.substring(start);
    }
}
