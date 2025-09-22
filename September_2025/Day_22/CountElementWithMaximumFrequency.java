//Question : https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int count = 1;
        int maxFreq = 0;
        
        // Count the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // Find maximum frequency and how many elements have that frequency
        for (int freq : freqMap.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
                count = 1;
            } else if (freq == maxFreq) {
                count++;
            }
        }

        // Total occurrences of elements with max frequency
        return maxFreq * count;
    }
}
