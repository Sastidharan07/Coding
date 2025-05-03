//Question : https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] count = new int[7];
        for (int i = 0; i < tops.length; i++) {
            count[tops[i]]++;
            if (tops[i] != bottoms[i]) {
                count[bottoms[i]]++;
            }
        }
        for (int x = 1; x <= 6; x++) {
            if (count[x] >= tops.length) {
                int rotationsTop = 0;
                int rotationsBottom = 0;
                for (int i = 0; i < tops.length; i++) {
                    if (tops[i] != x) rotationsTop++;
                    if (bottoms[i] != x) rotationsBottom++;
                }
                return Math.min(rotationsTop, rotationsBottom);
            }
        }

        return -1;
    }
}
