//Question:https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
class Solution {
    public long countOfSubstrings(String word, int k) {
        return a(word, k) - a(word, k + 1);
    }

    public long a(String s, int k) {
        int l = 0, e = 0, cons = 0;
        long ans = 0;
        HashMap<Character, Integer> m = new HashMap<>();

        while (e < s.length()) {
            if (isVowel(s.charAt(e))) {
                m.put(s.charAt(e), m.getOrDefault(s.charAt(e), 0) + 1);
            } else {
                cons++;
            }

            while (m.size() == 5 && cons >= k) {
                ans += s.length() - e;
                if (isVowel(s.charAt(l))) {
                    m.put(s.charAt(l), m.get(s.charAt(l)) - 1);
                    if (m.get(s.charAt(l)) == 0) {
                        m.remove(s.charAt(l));
                    }
                } else {
                    cons--;
                }
                l++;
            }
            e++;
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
