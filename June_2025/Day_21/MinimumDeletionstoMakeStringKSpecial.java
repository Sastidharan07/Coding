//Question : https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for(char c: word.toCharArray()){
            freq[c - 'a']++;
        }

        List<Integer> freqList = new ArrayList<>();
        for(int f: freq){
            if(f > 0) freqList.add(f);
        }

        int minDel = Integer.MAX_VALUE;
        for(int i = 1; i <= Collections.max(freqList); i++){
            int del = 0;
            for(int f: freqList){
                if(f < i - k){
                    del += f;
                } else if(f > i){
                    del += f - i;
                }
            }
            minDel = Math.min(minDel, del);
        }
        return minDel;
    }
}
