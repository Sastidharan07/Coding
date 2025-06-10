//Question : https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int max = Integer.MIN_VALUE;
        for(char c : s.toCharArray()){
            freq[c-97] = freq[c-97]+1;
        }

       for(int i = 0; i<freq.length - 1; i++){
            if(freq[i] == 0) continue;
            for(int j = i + 1; j<freq.length; j++){
                if(freq[j] == 0) continue;
                if((freq[i]%2==0 && freq[j]%2==0) || (freq[i] % 2 != 0 && freq[j] % 2 != 0)){
                    continue;
                }else{
                    if(freq[i]%2 != 0){
                        if(max < freq[i] - freq[j]){
                            max = freq[i] - freq[j];
                        }
                    }else{
                         if(max < freq[j] - freq[i]){
                            max = freq[j] - freq[i];
                        }
                    }
                }
            }
       }

        return max;
    }
}
