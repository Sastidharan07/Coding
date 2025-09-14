//Question : https://leetcode.com/problems/vowel-spellchecker/description/
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactSet.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactSet.contains(q)) {
                result[i] = q; // Rule 1
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower); // Rule 2
                } else {
                    String devowel = devowel(lower);
                    result[i] = vowelMap.getOrDefault(devowel, ""); // Rule 3
                }
            }
        }
        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
