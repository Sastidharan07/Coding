//Question:https://leetcode.com/problems/alternating-groups-ii/description/
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int altLen = 1;

        for(int i = 1; i < 2 * n; i++){
            if(colors[i%n] != colors[(i-1)%n]){
                altLen++;
            } else {
                altLen = 1;
            }

            if(altLen >= k && i >= n){
                count++;
            }
        }

        return count;
    }
}
