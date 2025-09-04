//Question : https://leetcode.com/problems/find-closest-person/description/
class Solution {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(z - x);
        int b = Math.abs(y - z);
        if (a == b) return 0;
        return (a < b) ? 1 : 2;
    }
}
