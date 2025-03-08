//Question:https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        char[] arr = blocks.toCharArray();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int count = 0, bla = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] == 'W') {
                    count++;
                }
                if (arr[j] == 'B') {
                    bla++;
                }
            }
            if (bla == k) {
                return 0;
            }
            min = Math.min(min, count);
        }
        return min;
    }
}
