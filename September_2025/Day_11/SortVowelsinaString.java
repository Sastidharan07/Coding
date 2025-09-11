//Question : https://leetcode.com/problems/sort-vowels-in-a-string/description/
class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        String v = "aeiouAEIOU";
        List<Character> vowels = new ArrayList<>();
        for (char c : arr) {
            if (v.indexOf(c) != -1) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (v.indexOf(arr[i]) != -1) {
                arr[i] = vowels.get(j++);
            }
        }

        return new String(arr);
    }
}
